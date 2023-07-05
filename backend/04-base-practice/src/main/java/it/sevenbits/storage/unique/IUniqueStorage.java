package it.sevenbits.storage.unique;

/**
 * The interface Unique storage.
 */
public interface IUniqueStorage {
    /**
     * Add.
     *
     * @param planetToAdd the planet to add
     */
    void add(String planetToAdd);

    /**
     * Remove.
     *
     * @param planetToRemove the planet to remove
     */
    void remove(String planetToRemove);

    /**
     * Contains boolean.
     *
     * @param planetToCheck the planet to check
     * @return the boolean
     */
    boolean contains(String planetToCheck);
}
