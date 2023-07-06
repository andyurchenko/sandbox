package it.sevenbits.tasks.two;

/**
 * The type User manager exception.
 */
public class UserManagerException extends Exception {
    /**
     * Instantiates a new User manager exception.
     *
     * @param s the s
     */
    public UserManagerException(final String s) {
        super(s);
    }

    /**
     * Instantiates a new User manager exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public UserManagerException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
