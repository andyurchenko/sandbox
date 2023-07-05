package com.tenexperts.summatra.array.summater;

import com.tenexperts.summatra.array.summater.exceptions.ArraySummaterException;
import com.tenexperts.summatra.array.summater.exceptions.ArraySummaterExceptionNullPointer;
import com.tenexperts.summatra.array.summater.exceptions.ArraySummaterExceptionOddElementsArray;
import com.tenexperts.summatra.array.summater.exceptions.ArraySummaterExceptionZeroArrayLength;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinPairSummaterTest {
    private MinPairSummater summater;

    @Before
    public void setUp() {
        this.summater = new MinPairSummater();
    }

    @Test(expected = ArraySummaterExceptionZeroArrayLength.class)
    public void testSumWithZeroLength() throws ArraySummaterException {
        int[] array = {};
        summater.sum(array);
    }

    @Test(expected = ArraySummaterExceptionNullPointer.class)
    public void testSumWithNullPointer() throws ArraySummaterException {
        int[] array = null;
        summater.sum(array);
    }

    @Test(expected = ArraySummaterExceptionOddElementsArray.class)
    public void testSumWithOddElements() throws ArraySummaterException {
        int[] array = {1, 2, 3};
        summater.sum(array);
    }

    @Test
    public void testSumWithEvenElements() {
        int[] array = {1, 2};
        try {
            assertEquals(3, summater.sum(array));
        } catch (ArraySummaterException exc) {
            System.out.println(exc);
        }

        int[] array2 = {1, 2, -3, -4};
        try {
            assertEquals(-7, summater.sum(array2));
        } catch (ArraySummaterException exc) {
            System.out.println(exc);
        }

        int[] array3 = {-100, 2, 3, 4};
        try {
            assertEquals(-98, summater.sum(array3));
        } catch (ArraySummaterException exc) {
            System.out.println(exc);
        }

        int[] array4 = {1, 2, -100, 4, 5, 6};
        try {
            assertEquals(-96, summater.sum(array4));
        } catch (ArraySummaterException exc) {
            System.out.println(exc);
        }

        int[] array5 = {1, -1, 100, -99, -5, -6};
        try {
            assertEquals(-11, summater.sum(array5));
        } catch (ArraySummaterException exc) {
            System.out.println(exc);
        }
    }
}
