package it.sevenbits.planet.concrete;

import it.sevenbits.planet.IPlanet;

import java.util.Objects;
import java.util.UUID;

/**
 * The type Planet.
 */
public final class Planet implements IPlanet {
    private java.lang.String name;
    private java.lang.String id;

    /**
     * Instantiates a new Planet.
     *
     * @param name the name
     */
    public Planet(final String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    /**
     * Instantiates a new Planet.
     *
     * @param name the name
     * @param id   the id
     */
    public Planet(final String name, final String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public java.lang.String getName() {
        return name;
    }

    @Override
    public java.lang.String getID() {
        return id;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Planet planet = (Planet) o;
        return Objects.equals(name, planet.name) && Objects.equals(id, planet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}


