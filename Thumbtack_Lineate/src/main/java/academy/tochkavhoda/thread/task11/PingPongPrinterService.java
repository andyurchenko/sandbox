package academy.tochkavhoda.thread.task11;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PingPongPrinterService {
    private final Lock l;
    private final Condition pongIsPrinted;
    private final Condition pingIsPrinted;
    private boolean pingTurn = true;
    private boolean pongTurn = false;

    public PingPongPrinterService() {
        l = new ReentrantLock();
        pongIsPrinted = l.newCondition();
        pingIsPrinted = l.newCondition();

    }

    public void printOncePing() {
        l.lock();
        try {
            while(pongTurn) {
                pongIsPrinted.await();
            }

            System.out.println("PING");
            pingTurn = false;
            pongTurn = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            pingIsPrinted.signal();
            l.unlock();
        }
    }

    public void printOncePong() {
        l.lock();
        try {
            while(pingTurn) {
                pingIsPrinted.await();
            }

            System.out.println("PONG");
            pingTurn = true;
            pongTurn = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            pongIsPrinted.signal();
            l.unlock();
        }
    }

}
