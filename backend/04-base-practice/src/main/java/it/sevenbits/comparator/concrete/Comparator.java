package it.sevenbits.comparator.concrete;

import it.sevenbits.comparator.IComparable;
import it.sevenbits.comparator.IComparator;
import it.sevenbits.planet.IPlanet;

/**
 * The type Comparator.
 */
public class Comparator implements IComparator {

    @Override
    public boolean compareTwoSetsOfPlanets(final IComparable firstSet, final IComparable secondSet) {
        IPlanet[] firstPlanets = firstSet.getPlanets().toArray(new IPlanet[0]);
        IPlanet[] secondPlants = secondSet.getPlanets().toArray(new IPlanet[0]);
        if (firstPlanets.length != secondPlants.length) {
            return false;
        }
        int arraySize = firstPlanets.length;
        boolean matchFound = false;
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                if (firstPlanets[i].getName().equals(secondPlants[j].getName())) {
                    matchFound = true;
                    break;
                }
            }
            if (!matchFound) {
                return false;
            }
            matchFound = false;
        }
        return true;
    }
}
