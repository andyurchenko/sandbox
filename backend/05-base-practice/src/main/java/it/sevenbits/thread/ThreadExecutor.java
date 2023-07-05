package it.sevenbits.thread;

import it.sevenbits.account.Account;
import it.sevenbits.thread.accountant.Accountant;

/**
 * The type Thread executor.
 */
public class ThreadExecutor {
    /**
     * Show account filling.
     *
     * @param millis the millis
     */
    public void showAccountFilling(final long millis) {
        Account account = new Account(0);
        Accountant accountant1 = new Accountant(account, 1, "First Accountant");
        Accountant accountant2 = new Accountant(account, 2, "Second Accountant");
        Accountant accountant3 = new Accountant(account, -4, "Third Accountant");
        this.sleepFor(millis);
        accountant1.stopRunning();
        accountant2.stopRunning();
        accountant3.stopRunning();
        accountant1.joinFor();
        accountant2.joinFor();
        accountant3.joinFor();
        account.showCurrentBalance();
    }

    private void sleepFor(final long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            System.out.println(Thread.currentThread().getName() + " is interrupted!");
        }
    }
}
