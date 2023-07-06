package academy.tochkavhoda.thread.task2;

public class Task2 {
    public static void main(String[] args) {
        Thread secondThread = new Thread(
                () -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        secondThread.start();
        System.out.println("Waiting for a second thread to stop.");
        try {
            secondThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Second thread has stopped running.");
    }
}
