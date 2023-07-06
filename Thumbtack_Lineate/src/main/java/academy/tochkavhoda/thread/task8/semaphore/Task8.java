package academy.tochkavhoda.thread.task8.semaphore;

public class Task8 {
    public static void main(String[] args) {
        AccessService accessService = new AccessService();
        Product product = new Product();
        Getter getter = new Getter(product, accessService);
        Setter setter = new Setter(product, accessService);

        new Thread(getter).start();
        new Thread(setter).start();

    }
}
