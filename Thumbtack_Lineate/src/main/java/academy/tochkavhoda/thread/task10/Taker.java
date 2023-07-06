package academy.tochkavhoda.thread.task10;

import java.util.List;
import java.util.concurrent.locks.Lock;

public class Taker implements Runnable {
    private Lock l;
    private List<Integer> list;

    public Taker(Lock l, List<Integer> list) {
        this.l = l;
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10000; i++) {
            l.lock();
            int index = (int)(Math.random() * list.size());
            if (index != 0) {
                System.out.println("Take: " + list.remove(index));
            }
            l.unlock();
        }
    }
}
