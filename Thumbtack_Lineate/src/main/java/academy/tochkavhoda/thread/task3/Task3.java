package academy.tochkavhoda.thread.task3;

class WaitingFor implements Runnable {
    private final int timeToWaitInMs;
    private final String threadName;

    public WaitingFor(int timeToWaitInMs, String threadName) {
        this.timeToWaitInMs = timeToWaitInMs;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println("Running now - " + threadName);
        Thread.currentThread().setName(threadName);
        try {
            Thread.sleep(timeToWaitInMs);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Stopped running - " + threadName);
    }
}

public class Task3 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new WaitingFor(3000, "thread1"));
        Thread thread2 = new Thread(new WaitingFor(4000, "thread2"));
        Thread thread3 = new Thread(new WaitingFor(5000, "thread3"));
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
