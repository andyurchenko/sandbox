package it.sevenbits.courses.sm.network;

/**
 * The interface Network.
 */
public interface INetwork {

    /**
     * Has package boolean.
     *
     * @return the boolean
     */
    boolean hasPackage();

    /**
     * Gets package.
     *
     * @return the package
     */
    NetworkPackage getPackage();

    /**
     * Add package.
     *
     * @param message the message
     * @param type    the type
     */
    void addPackage(String message, String type);
}
