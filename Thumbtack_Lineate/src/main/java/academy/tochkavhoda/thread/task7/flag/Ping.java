package academy.tochkavhoda.thread.task7.flag;

class Ping implements Runnable {
    private PingPong ping;

    public Ping(PingPong ping) {
        this.ping = ping;
    }

    @Override
    public void run() {
        while (true) {
            ping.printPing();
        }
    }
}
