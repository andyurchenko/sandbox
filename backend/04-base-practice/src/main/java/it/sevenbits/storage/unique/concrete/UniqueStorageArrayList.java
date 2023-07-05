package it.sevenbits.storage.unique.concrete;

import it.sevenbits.comparator.IComparable;
import it.sevenbits.logger.ILogger;
import it.sevenbits.planet.IPlanet;
import it.sevenbits.planet.factory.IPlanetFactory;
import it.sevenbits.storage.unique.IUniqueStorage;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Unique storage array list.
 */
public class UniqueStorageArrayList implements IUniqueStorage, IComparable {

    private ILogger logger;
    private List<IPlanet> listOfPlanets;
    private IPlanetFactory planetFactory;

    /**
     * Instantiates a new Unique storage array list.
     *
     * @param logger        the logger
     * @param planetFactory the planet factory
     */
    public UniqueStorageArrayList(final ILogger logger, final IPlanetFactory planetFactory) {
        listOfPlanets = new ArrayList<>();
        this.planetFactory = planetFactory;
        this.logger = logger;
    }

    @Override
    public void add(final String planetToAdd) {
        try {
            this.addToList(planetToAdd);
        } catch (NullPointerException ex) {
            logger.error(ex.getMessage());
        }
    }

    private void addToList(final String planetToAdd) {
        if (this.findInList(planetToAdd) == -1) {
            listOfPlanets.add(planetFactory.createPlanet(planetToAdd));
            logger.info(planetToAdd + " has been added successfully.");
        } else {
            logger.warn(planetToAdd + " already exists.");
        }
    }

    @Override
    public void remove(final String planetToRemove) {
        try {
            this.removeFromList(planetToRemove);
        } catch (Exception ex) {
            logger.error(this.convertStackTraceToString(ex));
        }
    }

    private void removeFromList(final String planetToRemove) {
        int indexOfPlanet = this.findInList(planetToRemove);
        if (indexOfPlanet != -1 && this.listOfPlanets.remove(indexOfPlanet) != null) {
            logger.info(planetToRemove + " has been removed successfully.");
        } else {
            logger.warn(planetToRemove + " has not been found.");
        }
    }

    private int findInList(final String planetNameToFind) {
        int indexOfPlanet = 0;
        for (IPlanet planet : this.listOfPlanets) {
           if (planetNameToFind.equals(planet.getName())) {
               return indexOfPlanet;
           }
           indexOfPlanet++;
        }
        return -1;
    }

    @Override
    public boolean contains(final String planetToCheck) {
        try {
            return this.containsInList(planetToCheck);
        } catch (Exception ex) {
            logger.error(this.convertStackTraceToString(ex));
            return false;
        }
    }

    private boolean containsInList(final String planetToCheck) {
        int indexOfPlanet = this.findInList(planetToCheck);
        if (indexOfPlanet != -1) {
            logger.info(planetToCheck + " exists.");
            return true;
        } else {
            logger.info(planetToCheck + " does NOT exist.");
            return false;
        }
    }

    private String convertStackTraceToString(final Throwable exception) {
        try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
            exception.printStackTrace(pw);
            return sw.toString();
        } catch (IOException ex) {
            return "Error in convertStackTraceToString() method : " + ex.getMessage();
        }
    }

    @Override
    public List<IPlanet> getPlanets() {
        return this.listOfPlanets;
    }
}
