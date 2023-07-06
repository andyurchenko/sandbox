package it.sevenbits.planet.factory;

import it.sevenbits.planet.IPlanet;

/**
 * The interface Planet factory.
 */
public interface IPlanetFactory {
    /**
     * Create planet planet.
     *
     * @param name the name
     * @return the planet
     */
    IPlanet createPlanet(String name);

    /**
     * Create planet planet.
     *
     * @param name the name
     * @param key  the key
     * @return the planet
     */
    IPlanet createPlanet(String name, String key);
}
