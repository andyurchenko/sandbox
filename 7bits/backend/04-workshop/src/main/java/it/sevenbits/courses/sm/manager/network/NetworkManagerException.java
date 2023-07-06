package it.sevenbits.courses.sm.manager.network;

/**
 * The type Network manager exception.
 */
public class NetworkManagerException extends Exception {

    /**
     * Instantiates a new Network manager exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public NetworkManagerException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Network manager exception.
     *
     * @param message the message
     */
    public NetworkManagerException(final String message) {
        super(message);
    }
}
