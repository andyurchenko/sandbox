package it.sevenbits.planet.factory.сoncrete;

import it.sevenbits.planet.IPlanet;
import it.sevenbits.planet.concrete.Planet;
import it.sevenbits.planet.factory.IPlanetFactory;

/**
 * The type Planet factory one.
 */
public class PlanetFactoryOne implements IPlanetFactory {
    @Override
    public IPlanet createPlanet(final String name) {
        return new Planet(name);
    }

    @Override
    public IPlanet createPlanet(final String name, final String key) {
        return new Planet(name, key);
    }
}
