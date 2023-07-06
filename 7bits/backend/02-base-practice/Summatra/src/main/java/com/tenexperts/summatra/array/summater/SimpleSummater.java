package com.tenexperts.summatra.array.summater;

import com.tenexperts.summatra.array.summater.exceptions.ArraySummaterException;
import com.tenexperts.summatra.array.summater.exceptions.ArraySummaterExceptionNullPointer;
import com.tenexperts.summatra.array.summater.exceptions.ArraySummaterExceptionZeroArrayLength;
import com.tenexperts.summatra.array.summater.interfaces.IArraySummater;

public class SimpleSummater implements IArraySummater {

    @Override
    public int sum(final int[] inArray) throws ArraySummaterException {
        if (inArray == null) {
            throw new ArraySummaterExceptionNullPointer();
        } else if (inArray.length == 0) {
            throw new ArraySummaterExceptionZeroArrayLength();
        } else {
            return getTotalSumOfAllElementsOfArray(inArray);
        }
    }

    private int getTotalSumOfAllElementsOfArray(final int[] inArray) {
        int sum = 0;
        for (final int element : inArray) {
            sum += element;
        }
        return sum;
    }
}
