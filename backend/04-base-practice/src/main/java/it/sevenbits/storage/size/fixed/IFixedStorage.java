package it.sevenbits.storage.size.fixed;

import it.sevenbits.planet.IPlanet;

/**
 * The interface Fixed storage.
 */
public interface IFixedStorage {
    /**
     * Add.
     *
     * @param key   the key
     * @param value the value
     */
//add(key, value), remove(key), value get(key), contains(value)
    void add(String key, IPlanet value);

    /**
     * Add.
     *
     * @param key   the key
     * @param value the value
     */
    void add(String key, String value);

    /**
     * Remove.
     *
     * @param key the key
     */
    void remove(String key);

    /**
     * Get planet.
     *
     * @param key the key
     * @return the planet
     */
    IPlanet get(String key);

    /**
     * Contains boolean.
     *
     * @param planetName the planet name
     * @return the boolean
     */
    boolean contains(IPlanet planetName);

    /**
     * Contains boolean.
     *
     * @param planetName the planet name
     * @return the boolean
     */
    boolean contains(String planetName);
}
