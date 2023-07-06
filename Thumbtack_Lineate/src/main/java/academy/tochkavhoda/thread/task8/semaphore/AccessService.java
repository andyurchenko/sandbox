package academy.tochkavhoda.thread.task8.semaphore;

import java.util.concurrent.Semaphore;

public class AccessService {
    private final Semaphore getterSemaphore;
    private final Semaphore setterSemaphore;

    public AccessService() {
        getterSemaphore = new Semaphore(0);
        setterSemaphore = new Semaphore(1);
    }

    public void acquirePermissionToGet() {
        try {
            getterSemaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void allowPermissionToGet() {
        getterSemaphore.release();
    }

    public void acquirePermissionToSet() {
        try {
            setterSemaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void allowPermissionToSet() {
        setterSemaphore.release();
    }
}
