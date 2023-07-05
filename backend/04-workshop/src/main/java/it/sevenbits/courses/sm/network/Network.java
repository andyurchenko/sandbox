package it.sevenbits.courses.sm.network;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * The type Network.
 */
public class Network implements INetwork {
    private final int maxSize;
    private ConcurrentLinkedDeque<NetworkPackage> packages = new ConcurrentLinkedDeque<NetworkPackage>();
    private final Logger logger = LoggerFactory.getLogger(Network.class);

    /**
     * Instantiates a new Network.
     *
     * @param maxSize the max size
     */
    public Network(final int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public boolean hasPackage() {
       return packages.size() > 0;
    }

    @Override
    public NetworkPackage getPackage() {
        logger.debug("Getting another packaged from network");
        return packages.removeFirst();
    }

    @Override
    public void addPackage(final String message, final String type) {
        if (packages.size() < maxSize) {
            logger.debug("Sending another packaged to network");
            packages.addLast(new NetworkPackage(type, message));
        } else {
            logger.error("Error has occurred during trying to send another package to network.");
        }

    }
}
