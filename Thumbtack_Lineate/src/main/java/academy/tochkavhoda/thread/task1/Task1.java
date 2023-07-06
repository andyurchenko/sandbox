package academy.tochkavhoda.thread.task1;

public class Task1 {
    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        System.out.println("Name - " + currentThread.getName());
        System.out.println("ID - " + currentThread.getId());
        System.out.println("Class - " + currentThread.getClass());
        System.out.println("ThreadGroup - " + currentThread.getThreadGroup());
        System.out.println("Priority - " + currentThread.getPriority());
        System.out.println("State - " + currentThread.getState());
    }
}
