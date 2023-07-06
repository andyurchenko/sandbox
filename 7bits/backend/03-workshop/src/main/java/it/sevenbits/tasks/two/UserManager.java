package it.sevenbits.tasks.two;

import java.io.IOException;

/**
 * The type User manager.
 */
public class UserManager {
    private ICollection collection;
    private final String DEFAULT_ROLE = "default";

    /**
     * Instantiates a new User manager.
     *
     * @param collection the collection
     */
    public UserManager(final ICollection collection) {
        this.collection = collection;
    }

    /**
     * Gets user by index.
     *
     * @param id the id
     * @return the user by index
     * @throws UserManagerException the user manager exception
     */
    public User getUserByIndex(final long id) throws UserManagerException {
        try {
            return collection.get(id);
        } catch (IOException e) {
            throw new UserManagerException("Can’t get user by index", e);
        }
    }

    /**
     * Create default.
     *
     * @param name the name
     * @throws UserManagerException the user manager exception
     */
    public void createDefault(final String name) throws UserManagerException {
        try {
            collection.add(new User(name, DEFAULT_ROLE));
        } catch (IOException e) {
            throw new UserManagerException("Can’t add user to collection", e);
        }
    }
}

