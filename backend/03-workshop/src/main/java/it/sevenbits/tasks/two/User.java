package it.sevenbits.tasks.two;

/**
 * The type User.
 */
public class User {
    private String name;
    private String role;

    /**
     * Instantiates a new User.
     *
     * @param name the name
     * @param role the role
     */
    public User(final String name, final String role) {
        this.name = name;
        this.role = role;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }
}
