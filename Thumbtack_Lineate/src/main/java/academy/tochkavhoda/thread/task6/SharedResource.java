package academy.tochkavhoda.thread.task6;

import java.util.Collections;
import java.util.List;

public class SharedResource {
    public final List<Integer> list;

    public SharedResource(List<Integer> list) {
        this.list = Collections.synchronizedList(list);
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
