package it.sevenbits.account;

import java.util.UUID;

/**
 * The type Account.
 */
public class Account implements Comparable<Account> {
    private final String id;
    private long balance;

    /**
     * Instantiates a new Account.
     *
     * @param balance the balance
     */
    public Account(final long balance) {
        id = UUID.randomUUID().toString();
        this.balance = balance;
    }

    /**
     * Add to balance.
     *
     * @param value the value
     */
    public void addToBalance(final long value) {
        long balance = this.balance;
        this.sleepFor(1);
        this.balance = balance + value;
    }

    private void sleepFor(final long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            System.out.println(Thread.currentThread().getName() + " is interrupted!");
        }
    }

    /**
     * Show current balance.
     */
    public void showCurrentBalance() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("Account id: %s with balance %s", id, balance);
    }

    @Override
    public int compareTo(final Account o) {
        return Long.compare(this.balance, o.balance);
    }
}


