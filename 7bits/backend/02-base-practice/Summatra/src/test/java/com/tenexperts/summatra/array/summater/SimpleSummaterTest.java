package com.tenexperts.summatra.array.summater;

import com.tenexperts.summatra.array.summater.exceptions.ArraySummaterException;
import com.tenexperts.summatra.array.summater.exceptions.ArraySummaterExceptionNullPointer;
import com.tenexperts.summatra.array.summater.exceptions.ArraySummaterExceptionZeroArrayLength;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleSummaterTest {
    private SimpleSummater summater;

    @Before
    public void setUp() {
        summater = new SimpleSummater();
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

    @Test
    public void testSum() {
        int[] array = {1, 2, 3};
        try {
            assertEquals(6, summater.sum(array));
        } catch (ArraySummaterException exc) {
            System.out.println(exc);
        }

        int[] array2 = {1, 2, 3, 1000};
        try {
            assertEquals(1006, summater.sum(array2));
        } catch (ArraySummaterException exc) {
            System.out.println(exc);
        }

        int[] array3 = {1, -1, 1, -1};
        try {
            assertEquals(0, summater.sum(array3));
        } catch (ArraySummaterException exc) {
            System.out.println(exc);
        }
    }
}
