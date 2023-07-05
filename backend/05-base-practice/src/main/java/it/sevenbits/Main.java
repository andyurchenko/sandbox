package it.sevenbits;

import it.sevenbits.gen.list.ListOperator;
import it.sevenbits.thread.ThreadExecutor;
import it.sevenbits.account.Account;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * The type Main.
 */
public final  class Main {
    private static final int LIST_SIZE = 10;
    private static final int MAX_NUMBER_VALUE = 100;

    private Main() {
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(final String[] args) {

        List<Integer> intList  = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < Main.LIST_SIZE; i++) {
            intList.add(random.nextInt(MAX_NUMBER_VALUE));
        }
        System.out.println("Max element in array is " + ListOperator.max(intList, 0, LIST_SIZE - 1));

        List<Account> accounts = new LinkedList<>();
        for (int i = 0; i < Main.LIST_SIZE; i++) {
            accounts.add(new Account(random.nextInt(MAX_NUMBER_VALUE)));
        }
        System.out.println(ListOperator.max(accounts, 0, LIST_SIZE - 1));

        System.out.println();

        ThreadExecutor threadExecutor = new ThreadExecutor();
        threadExecutor.showAccountFilling(5000);
    }

}