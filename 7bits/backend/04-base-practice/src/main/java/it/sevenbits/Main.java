package it.sevenbits;

import it.sevenbits.comparator.IComparable;
import it.sevenbits.comparator.IComparator;
import it.sevenbits.comparator.concrete.Comparator;
import it.sevenbits.logger.ILogger;
import it.sevenbits.logger.concrete.LoggerSLF4J;
import it.sevenbits.planet.IPlanet;
import it.sevenbits.planet.factory.IPlanetFactory;
import it.sevenbits.planet.factory.сoncrete.PlanetFactoryOne;
import it.sevenbits.storage.size.fixed.IFixedStorage;
import it.sevenbits.storage.size.fixed.concrete.FixedStorageHashMap;
import it.sevenbits.storage.unique.IUniqueStorage;
import it.sevenbits.storage.unique.concrete.UniqueStorageArrayList;

/**
 * The type Main.
 */
public final class Main {

    private Main() {
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(final String[] args) {
        ILogger logger1 = new LoggerSLF4J(UniqueStorageArrayList.class);
        IPlanetFactory planetFactory = new PlanetFactoryOne();
        IUniqueStorage uniqueStorage = new UniqueStorageArrayList(logger1, planetFactory);

        uniqueStorage.add("first planet");
        uniqueStorage.add("first planet");
        uniqueStorage.add("second planet");
        uniqueStorage.add("third planet");
        uniqueStorage.add("fourth planet");
        uniqueStorage.add("fifth planet");
        uniqueStorage.add("sixth planet");
        uniqueStorage.remove("sixth planet");
        uniqueStorage.add("sixth planet");
        uniqueStorage.add("seventh planet");
        uniqueStorage.remove("planet");

        ILogger logger2 = new LoggerSLF4J(FixedStorageHashMap.class);
        IFixedStorage fixedStorage = new FixedStorageHashMap(logger2, planetFactory, 7);

        IPlanet firstPlanet = planetFactory.createPlanet("first planet");
        IPlanet secondPlanet = planetFactory.createPlanet("second planet");
        IPlanet thirdPlanet = planetFactory.createPlanet("third planet");
        IPlanet fourthPlanet = planetFactory.createPlanet("fourth planet");
        IPlanet fifthPlanet = planetFactory.createPlanet("fifth planet");
        IPlanet sixthPlanet = planetFactory.createPlanet("sixth planet");
        IPlanet seventhPlanet = planetFactory.createPlanet("seventh planet");
        IPlanet eighthPlanet = planetFactory.createPlanet("eighth planet");

        fixedStorage.add(firstPlanet.getID(), firstPlanet);
        fixedStorage.add(secondPlanet.getID(), secondPlanet);
        fixedStorage.add(thirdPlanet.getID(), thirdPlanet);
        fixedStorage.add(fourthPlanet.getID(), fourthPlanet);
        fixedStorage.add(fifthPlanet.getID(), fifthPlanet);
        fixedStorage.add(sixthPlanet.getID(), sixthPlanet);
        fixedStorage.add(seventhPlanet.getID(), seventhPlanet);
        fixedStorage.contains("seventh planet");

        fixedStorage.add(eighthPlanet.getID(), eighthPlanet);
        fixedStorage.contains("eighth planet");

        fixedStorage.remove(seventhPlanet.getID());
        fixedStorage.contains("seventh planet");

        fixedStorage.add(eighthPlanet.getID(), eighthPlanet);
        fixedStorage.contains("eighth planet");

        IComparator comparator = new Comparator();
        System.out.println(comparator.compareTwoSetsOfPlanets((IComparable) uniqueStorage, (IComparable) fixedStorage));

        fixedStorage.remove(eighthPlanet.getID());
        fixedStorage.add(seventhPlanet.getID(), seventhPlanet);

        System.out.println(comparator.compareTwoSetsOfPlanets((IComparable) uniqueStorage, (IComparable) fixedStorage));

    }
}