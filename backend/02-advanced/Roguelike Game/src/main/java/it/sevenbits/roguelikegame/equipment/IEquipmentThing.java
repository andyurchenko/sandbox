package it.sevenbits.roguelikegame.equipment;

/**
 * The interface Inventory.
 */
public interface IEquipmentThing {
    /**
     * Gets size.
     *
     * @return the size
     */
    int getSize();

    /**
     * Sets size.
     *
     * @param size the size
     */
    void setSize(int size);

    /**
     * Gets weight.
     *
     * @return the weight
     */
    int getWeight();

    /**
     * Sets weight.
     *
     * @param weight the weight
     */
    void setWeight(int weight);

    /**
     * Gets name.
     *
     * @return the name
     */
    String getName();

    /**
     * Sets name.
     *
     * @param name the name
     */
    void setName(String name);
}
