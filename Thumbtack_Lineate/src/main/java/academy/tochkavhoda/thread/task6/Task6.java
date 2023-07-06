package academy.tochkavhoda.thread.task6;

import java.util.ArrayList;

public class Task6 {
    private static final int TIMES_TO_RUN = 10000;
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(new ArrayList<>());

        Adder adder = new Adder(sharedResource, TIMES_TO_RUN);
        Thread threadAdder = new Thread(adder);

        Remover remover = new Remover(sharedResource, TIMES_TO_RUN);
        Thread threadRemover = new Thread(remover);

        threadAdder.start();
        threadRemover.start();

        try {
            threadAdder.join();
            threadRemover.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
