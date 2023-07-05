package com.tenexperts.summatra.array.summater;

import com.tenexperts.summatra.array.summater.exceptions.ArraySummaterException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MaxPairSummaterTest {
    private MaxPairSummater summater;

    @Before
    public void setUp() {
        this.summater = new MaxPairSummater();
    }

    @Test
    public void testSumWithZeroLength() {
        int[] array = {};
        try {
            assertEquals(0, summater.sum(array));
        } catch (ArraySummaterException exc) {
            System.out.println(exc);
        }
    }

    @Test(expected = ArraySummaterException.class)
    public void testSumWithOddElements() throws ArraySummaterException {
        int[] array = {1, 2, 3};
        assertEquals(0, summater.sum(array));
    }

    @Test
    public void testSumWithEvenElements() {
        int[] array = {1, 2};
        try {
            assertEquals(3, summater.sum(array));
        } catch (ArraySummaterException exc) {
            System.out.println(exc);
        }

        int[] array2 = {1, 2, 3, 4};
        try {
            assertEquals(7, summater.sum(array2));
        } catch (ArraySummaterException exc) {
            System.out.println(exc);
        }

        int[] array3 = {100, 2, 3, 4};
        try {
            assertEquals(102, summater.sum(array3));
        } catch (ArraySummaterException exc) {
            System.out.println(exc);
        }

        int[] array4 = {1, 2, 100, 4, 5, 6};
        try {
            assertEquals(104, summater.sum(array4));
        } catch (ArraySummaterException exc) {
            System.out.println(exc);
        }

        int[] array5 = {1, -1, 100, -99, -5, -6};
        try {
            assertEquals(1, summater.sum(array5));
        } catch (ArraySummaterException exc) {
            System.out.println(exc);
        }
    }
}
