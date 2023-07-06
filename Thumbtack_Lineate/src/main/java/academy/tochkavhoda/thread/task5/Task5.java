package academy.tochkavhoda.thread.task5;

import java.util.ArrayList;
import java.util.List;

public class Task5 {
    private static final int TIMES_TO_RUN = 10000;
    public static void main(String[] args) {
        List<Integer> tempList = new ArrayList<>();
        tempList.size();
        tempList.add(42);
        tempList.size();
        SharedResource sharedResource = new SharedResource(new ArrayList<>());

        ActionOnResource adder = new ActionOnResource(sharedResource, TIMES_TO_RUN, Action.ADD);
        Thread threadAdder = new Thread(adder);

        ActionOnResource remover = new ActionOnResource(sharedResource, TIMES_TO_RUN, Action.REMOVE);
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
