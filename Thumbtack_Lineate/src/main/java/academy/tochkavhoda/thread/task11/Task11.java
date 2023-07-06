package academy.tochkavhoda.thread.task11;

public class Task11 {
    public static void main(String[] args) {
        PingPongPrinterService service = new PingPongPrinterService();
        PingPrinter pingPrinter = new PingPrinter(service, 500);
        PongPrinter pongPrinter = new PongPrinter(service, 500);
        new Thread(pingPrinter).start();
        new Thread(pongPrinter).start();
    }
}
