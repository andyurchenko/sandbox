package it.sevenbits.comparator;

/**
 * The interface Comparator.
 */
public interface IComparator {
    /**
     * Compare two sets of planets boolean.
     *
     * @param firstSet  the first set
     * @param secondSet the second set
     * @return the boolean
     */
    boolean compareTwoSetsOfPlanets(IComparable firstSet, IComparable secondSet);
}
