package academy.tochkavhoda.thread.task7.semaphore;

public class Task7 {
    public static void main(String[] args) {
        PingPongPrinterService service = new PingPongPrinterService();
        PingPrinter pingPrinter = new PingPrinter(service, 500);
        PongPrinter pongPrinter = new PongPrinter(service, 500);
        new Thread(pingPrinter).start();
        new Thread(pongPrinter).start();
    }
}
