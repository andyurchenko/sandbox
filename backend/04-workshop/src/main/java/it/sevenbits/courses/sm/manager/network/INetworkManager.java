package it.sevenbits.courses.sm.manager.network;

import it.sevenbits.courses.sm.network.INetwork;

/**
 * The interface Network manager.
 */
public interface INetworkManager {

    /**
     * Listen.
     *
     * @param network the network
     * @throws NetworkManagerException the network manager exception
     */
    void listen(INetwork network) throws NetworkManagerException;

    /**
     * Stop.
     */
    void stop();
}
