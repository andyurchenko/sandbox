package academy.tochkavhoda.thread.task7.flag;

public class Task7 {
    public static void main(String[] args) {
        PingPong pingPong = new PingPong();
        new Thread(new Pong(pingPong)).start();
        new Thread(new Ping(pingPong)).start();
    }

}
