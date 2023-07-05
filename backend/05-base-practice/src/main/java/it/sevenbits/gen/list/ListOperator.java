package it.sevenbits.gen.list;

import java.util.List;

/**
 * The type List operator.
 */
public final class ListOperator {


    private ListOperator() {
    }

    /**
     * Max t.
     *
     * @param <T>              the type parameter
     * @param list             the list
     * @param indexToStartWith the index to start with
     * @param indexToFinishOn  the index to finish on
     * @return the t
     */
    public static <T extends Comparable<T>> T max(final List<T> list, final int indexToStartWith, final int indexToFinishOn) {
        if (indexToStartWith == indexToFinishOn) {
            return null;
        }
        if (indexToStartWith > indexToFinishOn) {
            return null;
        }
        T maxElement = list.get(indexToStartWith);
        T elementToCompareWith;
        for (int i = indexToStartWith + 1; i <= indexToFinishOn; i++) {
            elementToCompareWith = list.get(i);
            if (maxElement.compareTo(elementToCompareWith) < 0) {
               maxElement = list.get(i);
            }
        }
        return maxElement;
    }
}
