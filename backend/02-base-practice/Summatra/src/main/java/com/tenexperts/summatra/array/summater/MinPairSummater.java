package com.tenexperts.summatra.array.summater;

import com.tenexperts.summatra.array.summater.exceptions.ArraySummaterException;
import com.tenexperts.summatra.array.summater.exceptions.ArraySummaterExceptionNullPointer;
import com.tenexperts.summatra.array.summater.exceptions.ArraySummaterExceptionOddElementsArray;
import com.tenexperts.summatra.array.summater.exceptions.ArraySummaterExceptionZeroArrayLength;
import com.tenexperts.summatra.array.summater.interfaces.IArraySummater;

public class MinPairSummater implements IArraySummater {

    @Override
    public int sum(final int[] inArray) throws ArraySummaterException {
        if (inArray == null) {
            throw new ArraySummaterExceptionNullPointer();
        } else if (inArray.length == 0) {
            throw new ArraySummaterExceptionZeroArrayLength();
        } else if (!this.isArrayLengthEven(inArray.length)) {
            throw new ArraySummaterExceptionOddElementsArray();
        } else {
            return getMinSumOfPairs(inArray);
        }
    }

    private int getMinSumOfPairs(final int[] inArray) {
        int minSum = inArray[0] + inArray[1];
        for (int i = 1; i < (inArray.length / 2); i++) {
            int sumOfCurrentElementAndNextElement = getSumOfCurrentElementAndNextElement(i, inArray);
            minSum = Math.min(sumOfCurrentElementAndNextElement, minSum);
        }
        return minSum;
    }

    private int getSumOfCurrentElementAndNextElement(final int indexOfCurrentElement, final int[] inArray) {
        return  inArray[indexOfCurrentElement * 2] + inArray[indexOfCurrentElement * 2 + 1];
    }

    private boolean isArrayLengthEven(final int arrLength) {
        return this.isEven(arrLength);
    }

    private boolean isEven(final int value) {
        return (value % 2) == 0;
    }
}
