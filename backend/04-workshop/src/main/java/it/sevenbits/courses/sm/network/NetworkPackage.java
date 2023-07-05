package it.sevenbits.courses.sm.network;

import java.util.Objects;

/**
 * The type Network package.
 */
public class NetworkPackage implements INetworkPackage {
    private String type;
    private String message;

    /**
     * Instantiates a new Network package.
     *
     * @param type    the type
     * @param message the message
     */
    public NetworkPackage(final String type, final String message) {
        this.type = type;
        this.message = message;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NetworkPackage that = (NetworkPackage) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
