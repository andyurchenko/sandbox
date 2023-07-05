package it.sevenbits.storage.size.fixed.concrete;

import it.sevenbits.comparator.IComparable;
import it.sevenbits.logger.ILogger;
import it.sevenbits.planet.IPlanet;
import it.sevenbits.planet.factory.IPlanetFactory;
import it.sevenbits.storage.size.fixed.IFixedStorage;

import java.util.Collection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The type Fixed storage hash map.
 */
public class FixedStorageHashMap implements IFixedStorage, IComparable {
    private final ILogger logger;
    private final Map<String, IPlanet> mapOfPlanets;
    private final IPlanetFactory planetFactory;
    private final int MAX_SIZE;

    /**
     * Instantiates a new Fixed storage hash map.
     *
     * @param logger        the logger
     * @param planetFactory the planet factory
     * @param maxSize       the max size
     */
    public FixedStorageHashMap(final ILogger logger, final IPlanetFactory planetFactory, final int maxSize) {
        this.mapOfPlanets = new HashMap<>(maxSize, 1.0f);
        this.logger = logger;
        this.planetFactory = planetFactory;
        this.MAX_SIZE = maxSize;
    }

    @Override
    public void add(final String key, final IPlanet planetName) {
        if (enoughSpace()) {
            addToMap(key, planetName);
        } else {
            logger.warn("Storage is full. I cannot add " + planetName.getName());
        }
    }

    @Override
    public void add(final String key, final String planetName) {
        if (enoughSpace()) {
            addToMap(key, planetName);
        } else {
            logger.warn("Storage is full. I cannot add " + planetName);
        }
    }

    private boolean enoughSpace() {
        return (this.mapOfPlanets.size() < MAX_SIZE);
    }

    private void addToMap(final String key, final String planetName) {
        if (this.mapOfPlanets.put(key, planetFactory.createPlanet(planetName, key)) != null) {
            logger.info(key + " already exists. The value of key has been replaced with " + planetName);
        } else {
            logger.info(planetName + " has been added successfully.");
        }
    }

    private void addToMap(final String key, final IPlanet planet) {
        if (this.mapOfPlanets.put(key, planet) != null) {
            logger.info(key + " already exists. The value of key has been replaced with " + planet.getName());
        } else {
            logger.info(planet.getName() + " has been added successfully.");
        }
    }

    @Override
    public void remove(final String key) {
        IPlanet planet = this.mapOfPlanets.remove(key);
        if (planet != null) {
            logger.info(planet.getName() + " has been removed successfully.");
        } else {
            logger.info("Planet with " + key + " key has not been found. for method remove()");
        }
    }

    @Override
    public IPlanet get(final String key) {
        IPlanet planet = this.mapOfPlanets.get(key);
        if (planet != null) {
            logger.info(planet.getName() + " has been found successfully.");
        } else {
            logger.info("Planet with " + key + " key has not been found for method get().");
        }
        return planet;
    }


    @Override
    public boolean contains(final String planetName) {
        for (IPlanet planet : this.mapOfPlanets.values()) {
            if (planetName.equals(planet.getName())) {
                logger.info(planet.getName() + " exists.");
                return true;
            }
        }
        logger.info(planetName + " does not exists.");
        return false;
    }

    @Override
    public boolean contains(final IPlanet planet) {
        if (this.mapOfPlanets.containsValue(planet)) {
            logger.info(planet.getName() + " exists.");
            return true;
        } else {
            logger.info(planet.getName() + " does not exists.");
            return false;
        }
    }

    @Override
    public List<IPlanet> getPlanets() {
        Collection<IPlanet> planets = this.mapOfPlanets.values();
        return new ArrayList<>(planets);
    }
}
