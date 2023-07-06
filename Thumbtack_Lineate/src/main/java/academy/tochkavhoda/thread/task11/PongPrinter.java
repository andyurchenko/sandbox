package academy.tochkavhoda.thread.task11;

public class PongPrinter implements Runnable {
    private final PingPongPrinterService service;
    private final int delayBetweenPrintingInMs;

    public PongPrinter(PingPongPrinterService service, int delayBetweenPrintingInMs) {
        this.service = service;
        this.delayBetweenPrintingInMs = delayBetweenPrintingInMs;
    }

    @Override
    public void run() {
        while (true) {
            service.printOncePong();
            try {
                Thread.sleep(delayBetweenPrintingInMs);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
