package academy.tochkavhoda.thread.task7.semaphore;

import java.util.concurrent.Semaphore;

public class PingPongPrinterService {
    private final Semaphore ping;
    private final Semaphore pong;

    public PingPongPrinterService() {
        ping = new Semaphore(1);
        pong = new Semaphore(0);
    }

    public void printOncePing() {
        try {
            ping.acquire();
            System.out.println("PING");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            allowOncePongPrinting();
        }
    }

    public void printOncePong() {
        try {
            pong.acquire();
            System.out.println("PONG");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            allowOncePingPrinting();
        }
    }

    private void allowOncePongPrinting() {
        pong.release();
    }

    private void allowOncePingPrinting() {
        ping.release();
    }
}
