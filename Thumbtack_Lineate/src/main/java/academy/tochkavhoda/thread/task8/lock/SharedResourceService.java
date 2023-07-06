package academy.tochkavhoda.thread.task8.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResourceService<T> {
    private final T[] array;
    private int index;
    private final Lock l;
    private final Condition isNotFull;
    private final Condition isNotEmpty;

    public SharedResourceService(T[] array) {
        this.array = array;
        index = -1;
        l = new ReentrantLock();
        isNotFull = l.newCondition();
        isNotEmpty = l.newCondition();
    }

    public T getElement() {
        T element = null;
        l.lock();
        try {
            while (isResourceEmpty()) {
                isNotEmpty.await();
            }
            element = array[index--];
            isNotFull.signal();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            l.unlock();
        }

        return element;
    }

    public void addElement(T x) {
        l.lock();
        try {
            while(isResourceFull()) {
                isNotFull.await();
            }
            array[++index] = x;
            isNotEmpty.signal();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            l.unlock();
        }
    }

    private boolean isResourceEmpty() {
        return index == -1;
    }

    private boolean isResourceFull() {
        return index == array.length;
    }
}
