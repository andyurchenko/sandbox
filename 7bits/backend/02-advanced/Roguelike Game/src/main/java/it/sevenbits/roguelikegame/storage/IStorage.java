package it.sevenbits.roguelikegame.storage;

import it.sevenbits.roguelikegame.equipment.EquipmentThing;
import it.sevenbits.roguelikegame.equipment.IEquipmentThing;

/**
 * The interface Storage.
 */
public interface IStorage {

    /**
     * Gets max size.
     *
     * @return the max size
     */
    int getMaxSize();

    /**
     * Sets max size.
     *
     * @param maxSize the max size
     */
    void setMaxSize(int maxSize);

    /**
     * Gets value of free available space.
     *
     * @return the value of free available space
     */
    int getValueOfFreeAvailableSpace();

    /**
     * Put thing into.
     *
     * @param thingToPut the thing to put
     */
    void putThingInto(IEquipmentThing thingToPut);

    /**
     * Gets thing from.
     *
     * @param name the name
     * @return the thing from
     */
    IEquipmentThing getThingFrom(String name);

    /**
     * Is opened boolean.
     *
     * @return the boolean
     */
    boolean isOpened();

    /**
     * Is closed boolean.
     *
     * @return the boolean
     */
    boolean isClosed();

    /**
     * Open.
     */
    void open();

    /**
     * Close.
     */
    void close();
}
