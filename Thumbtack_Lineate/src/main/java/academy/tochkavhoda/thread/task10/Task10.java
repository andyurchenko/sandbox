package academy.tochkavhoda.thread.task10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task10 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Lock lock = new ReentrantLock();
        Adder adder = new Adder(lock, list);
        Taker taker = new Taker(lock, list);

        Thread adderThread = new Thread(adder);
        Thread takerThread = new Thread(taker);

        adderThread.start();
        takerThread.start();

        try {
            adderThread.join();
            takerThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Done");
    }
}
