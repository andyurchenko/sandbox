package academy.tochkavhoda.thread.task5;

public class ActionOnResource implements Runnable {
    private final SharedResource resource;
    private final int timesToRun;
    private final Action action;

    public ActionOnResource(SharedResource resource, int timesToRun, Action action) {
        this.resource = resource;
        this.timesToRun = timesToRun;
        this.action = action;
    }

    @Override
    public void run() {
        if (action == Action.ADD) {
            add();
        } else {
            remove();
        }
    }

    private void add() {
        for (int i = 0; i < timesToRun; i++) {
            resource.add((int)(Math.random() * 100));
        }
    }

    private void remove() {
        for (int i = 0; i < timesToRun; i++) {
            if (!resource.isResourceEmpty()) {
                resource.remove((int)(Math.random() * resource.getResourceSize()));
            }
        }
    }
}
