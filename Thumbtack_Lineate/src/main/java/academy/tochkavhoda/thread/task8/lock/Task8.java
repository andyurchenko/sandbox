package academy.tochkavhoda.thread.task8.lock;

public class Task8 {
    public static void main(String[] args) {


        SharedResourceService<Integer> resourceService = new SharedResourceService<>(new Integer[100]);
        Getter getter = new Getter(resourceService, 10);
        Adder adder = new Adder(resourceService, 10);
        Thread adderThread = new Thread(adder);
        Thread getterThread = new Thread(getter);

        adderThread.start();
        getterThread.start();

        try {
            adderThread.join();
            getterThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Done!");
    }
}
