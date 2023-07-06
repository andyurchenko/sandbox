package academy.tochkavhoda.thread.task8.lock;

public class Adder implements Runnable {
    private final SharedResourceService<Integer> resourceService;
    private final int timesToSet;

    public Adder(SharedResourceService<Integer> resourceService, int timesToSet) {
        this.resourceService = resourceService;
        this.timesToSet = timesToSet;
    }

    @Override
    public void run() {
        for (int i = timesToSet; i > 0; i--) {
            try {
                resourceService.addElement(i);
                System.out.println("Adder: " + i);
                Thread.sleep((int) (Math.random() * 1000));

            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
