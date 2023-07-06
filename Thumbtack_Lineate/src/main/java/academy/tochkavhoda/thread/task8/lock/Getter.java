package academy.tochkavhoda.thread.task8.lock;

public class Getter implements Runnable {
    private final SharedResourceService<Integer> resourceService;
    private final int timesToGet;

    public Getter(SharedResourceService<Integer> resourceService, int timesToGet) {
        this.resourceService = resourceService;
        this.timesToGet = timesToGet;
    }

    @Override
    public void run() {
        for (int i = timesToGet; i > 0; i--) {
            try {
                System.out.println("Getter: " + resourceService.getElement());
                Thread.sleep(500 + (int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
