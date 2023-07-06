package academy.tochkavhoda.thread.task13;

import java.util.Date;

public class Task13 {
    private static Formatter formatter;

    public static void main(String[] args) {
        formatter = new Formatter();

        Thread thread0 = new Thread(
                () -> formatter.format(new Date())
        );

        Thread thread1 = new Thread(
                () -> formatter.format(new Date())
        );

        Thread thread2 = new Thread(
                () -> formatter.format(new Date())
        );

        Thread thread3 = new Thread(
                () -> formatter.format(new Date())
        );

        Thread thread4 = new Thread(
                () -> formatter.format(new Date())
        );

        Thread thread5 = new Thread(
                () -> formatter.format(new Date())
        );

        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        try {
            thread0.join();
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(
                    () -> formatter.format(new Date())
            );

        }

        for (int i = 0; i < 100; i++) {
            threads[i].start();
        }

        try {
            for (int i = 0; i < 100; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
