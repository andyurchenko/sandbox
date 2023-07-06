package academy.tochkavhoda.thread.task4;

public class Remover implements Runnable {
    private final SharedResource resource;
    private final int timesToRun;

    public Remover(SharedResource resource, int timesToRun) {
        this.resource = resource;
        this.timesToRun = timesToRun;
    }

    @Override
    public void run() {
        for (int i = 0; i < timesToRun; i++) {
            synchronized (resource) {
                if (!resource.isResourceEmpty()) {
                    resource.remove((int)(Math.random() * resource.getResourceSize()));
                }
            }

        }
    }
}
