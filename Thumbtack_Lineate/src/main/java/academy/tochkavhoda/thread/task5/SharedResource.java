package academy.tochkavhoda.thread.task5;

import java.util.List;

public class SharedResource {
    public final List<Integer> list;

    public SharedResource(List<Integer> list) {
        this.list = list;
    }

    public synchronized void add(int x) {
        list.add(x);
    }

    public synchronized void remove(int index) {
        list.remove(index);

    }

    public int getResourceSize() {
        return list.size();
    }

    public boolean isResourceEmpty() {
        return list.isEmpty();
    }
}
