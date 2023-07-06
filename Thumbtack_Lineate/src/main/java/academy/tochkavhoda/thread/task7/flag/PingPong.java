package academy.tochkavhoda.thread.task7.flag;

class PingPong {
    private boolean pingPrinting = true;
    private boolean pongPrinting = false;

    public synchronized void printPing() {
        while(pongPrinting) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }

        System.out.println("PING");
        changeTurnToPong();
        notify();
    }

    public synchronized void printPong() {
        while(pingPrinting) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }

        System.out.println("PONG");
        changeTurnToPing();
        notify();
    }

    private void changeTurnToPing() {
        pongPrinting = false;
        pingPrinting = true;
    }

    private void changeTurnToPong() {
        pingPrinting = false;
        pongPrinting = true;
    }
}
