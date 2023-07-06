package academy.tochkavhoda.thread.task10;

import java.util.List;
import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {
    private Lock l;
    private List<Integer> list;

    public Adder(Lock l, List<Integer> list) {
        this.l = l;
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10000; i++) {
            l.lock();
            int x = (int)(Math.random() * 100);
            list.add(x);
            System.out.println("Adder: " + x);
            l.unlock();
        }
    }
}
