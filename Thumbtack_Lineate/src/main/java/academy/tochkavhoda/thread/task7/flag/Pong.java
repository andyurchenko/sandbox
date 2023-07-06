package academy.tochkavhoda.thread.task7.flag;

class Pong implements Runnable {
    private PingPong pong;

    public Pong(PingPong pong) {
        this.pong = pong;
    }

    @Override
    public void run() {
        while (true) {
            pong.printPong();
        }
    }
}