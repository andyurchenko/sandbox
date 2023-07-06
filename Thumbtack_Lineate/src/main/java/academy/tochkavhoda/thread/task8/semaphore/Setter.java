package academy.tochkavhoda.thread.task8.semaphore;

public class Setter implements Runnable {
    private final Product product;
    private final AccessService accessService;

    public Setter(Product product, AccessService accessService) {
        this.product = product;
        this.accessService = accessService;
    }

    @Override
    public void run() {
        while (true) {
            waitToSet();
            int randValue = (int) (Math.random() * 100);
            product.setValue(randValue);
            System.out.println("Setter: " + randValue);
            allowToGet();
        }
    }

    private void waitToSet() {
        accessService.acquirePermissionToSet();
    }

    private void allowToGet() {
        accessService.allowPermissionToGet();
    }
}
