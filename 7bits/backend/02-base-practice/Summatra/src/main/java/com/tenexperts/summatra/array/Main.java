package com.tenexperts.summatra.array;
import com.tenexperts.summatra.array.summater.MinPairSummater;
import com.tenexperts.summatra.array.summater.exceptions.ArraySummaterException;
import com.tenexperts.summatra.array.summater.interfaces.IArraySummater;
import com.tenexperts.summatra.array.summater.MaxPairSummater;
import com.tenexperts.summatra.array.summater.SimpleSummater;

public class Main {
    public static void main(final String[] args) {
        IArraySummater simpleSummater = new SimpleSummater();
        IArraySummater maxSummater = new MaxPairSummater();
        IArraySummater minSummater = new MinPairSummater();

        final int[] nullArray = null;
        final int[] oddArray = {1, 2, 3, 4, 5};

        try {
            final int[] evenArray = {1, 2, 3, 4};
            System.out.println("Sum of all elements of array is " + simpleSummater.sum(evenArray));
            System.out.println("Max sum of all pairs is " + maxSummater.sum(evenArray));
        } catch (ArraySummaterException exc) {
            System.out.println(exc);
        }

        //odd elements
        try {
            System.out.println("Max sum of all pairs is " + maxSummater.sum(oddArray));
        } catch (ArraySummaterException exc) {
            System.out.println(exc);
        }

        //odd elements
        try {
            System.out.println("Max sum of all pairs is " + minSummater.sum(oddArray));
        } catch (ArraySummaterException exc) {
            System.out.println(exc);
        }

        //null pointer
        try {
            System.out.println("Null pointer array " + maxSummater.sum(nullArray));
        } catch (ArraySummaterException exc) {
            System.out.println(exc);
        }

        //null pointer
        try {
            System.out.println("Null pointer array " + minSummater.sum(nullArray));
        } catch (ArraySummaterException exc) {
            System.out.println(exc);
        }

        //null pointer
        try {
            System.out.println("Null pointer array " + simpleSummater.sum(nullArray));
        } catch (ArraySummaterException exc) {
            System.out.println(exc);
        }
    }
}
