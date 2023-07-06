package it.sevenbits.thread.accountant;

import it.sevenbits.account.Account;

/**
 * The type Accountant.
 */
public class Accountant implements Runnable {
    private final Account currentAccount;
    private final int valueToChangeAccount;
    private boolean keepRunning = true;
    private final Thread thread;

    /**
     * Instantiates a new Accountant.
     *
     * @param account    the account
     * @param inValue    the in value
     * @param threadName the thread name
     */
    public Accountant(final Account account, final int inValue, final String threadName) {
        this.currentAccount = account;
        this.valueToChangeAccount = inValue;
        this.thread = new Thread(this, threadName);
        this.thread.start();
    }

    /**
     * Stop running.
     */
    public void stopRunning() {
        this.keepRunning = false;
    }

    /**
     * Join for.
     */
    public void joinFor() {
        try {
            this.thread.join();
        } catch (InterruptedException ex) {
            System.out.println(Thread.currentThread().getName() + " is interrupted!");
        }
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is started!");
        while (keepRunning) {
            synchronized (this.currentAccount) {
                this.currentAccount.addToBalance(this.valueToChangeAccount);
            }
        }
        System.out.println(Thread.currentThread().getName() + " is stopped!");
    }
}
