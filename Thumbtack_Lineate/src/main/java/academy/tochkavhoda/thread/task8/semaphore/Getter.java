package academy.tochkavhoda.thread.task8.semaphore;


public class Getter implements Runnable {
    private final Product product;
    private final AccessService accessService;

    public Getter(Product product, AccessService accessService) {
        this.product = product;
        this.accessService = accessService;
    }

    @Override
    public void run() {
        while (true) {
            waitToGet();
            System.out.println(" Getter: " + product.getValue());
//            sleep();
            allowToSet();
        }
    }

    private void waitToGet() {
        accessService.acquirePermissionToGet();
    }

    private void allowToSet() {
        accessService.allowPermissionToSet();
    }

    private void sleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
