package academy.tochkavhoda.thread.task7.sleep;

class Ping implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("PING");
            sleep();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Pong implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("PONG");
            sleep();
        }

    }

    private void sleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class Task7_sleep {
    public static void main(String[] args) {
        new Thread(new Ping()).start();
        new Thread(new Pong()).start();
    }
}
