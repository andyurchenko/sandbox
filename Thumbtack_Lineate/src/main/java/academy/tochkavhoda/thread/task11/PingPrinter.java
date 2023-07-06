package academy.tochkavhoda.thread.task11;

public class PingPrinter implements Runnable {
    private final PingPongPrinterService service;
    private final int delayBetweenPrintingInMs;

    public PingPrinter(PingPongPrinterService service, int delayBetweenPrintingInMs) {
        this.service = service;
        this.delayBetweenPrintingInMs = delayBetweenPrintingInMs;
    }

    @Override
    public void run() {
        while (true) {
            service.printOncePing();
            try {
                Thread.sleep(delayBetweenPrintingInMs);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
