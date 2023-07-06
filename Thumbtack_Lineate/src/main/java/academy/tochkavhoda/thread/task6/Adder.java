package academy.tochkavhoda.thread.task6;

public class Adder implements Runnable {
    private final SharedResource resource;
    private final int timesToRun;

    public Adder(SharedResource resource, int timesToRun) {
        this.resource = resource;
        this.timesToRun = timesToRun;
    }

    @Override
    public void run() {
        for (int i = 0; i < timesToRun; i++) {
            resource.add((int)(Math.random() * 100));
        }
    }
}
