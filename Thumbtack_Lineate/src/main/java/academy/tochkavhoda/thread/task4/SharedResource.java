package academy.tochkavhoda.thread.task4;

import java.util.ArrayList;
import java.util.List;

public class SharedResource {
    public final List<Integer> list;

    public SharedResource(List<Integer> list) {
        this.list = list;
    }

    public void add(int x) {
        list.add(x);
    }

    public void remove(int index) {
        list.remove(index);
    }

    public int getResourceSize() {
        return list.size();
    }

    public boolean isResourceEmpty() {
        return list.isEmpty();
    }
}
