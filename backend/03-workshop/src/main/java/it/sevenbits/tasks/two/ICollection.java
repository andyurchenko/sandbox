package it.sevenbits.tasks.two;

import java.io.IOException;

/**
 * The interface Collection.
 */
public interface ICollection {
    /**
     * Add.
     *
     * @param user the user
     * @throws IOException the io exception
     */
    void add(User user) throws IOException;

    /**
     * Get user.
     *
     * @param index the index
     * @return the user
     * @throws IOException the io exception
     */
    User get(long index) throws IOException;
}
