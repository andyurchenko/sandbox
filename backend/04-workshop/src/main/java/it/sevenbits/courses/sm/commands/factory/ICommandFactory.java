package it.sevenbits.courses.sm.commands.factory;

import it.sevenbits.courses.sm.commands.INetworkManagerCommand;
import it.sevenbits.courses.sm.network.INetworkPackage;

/**
 * The interface Command factory.
 */
public interface ICommandFactory {
    /**
     * Gets command.
     *
     * @param state          the state
     * @param networkPackage the network package
     * @return the command
     */
    INetworkManagerCommand getCommand(String state, INetworkPackage networkPackage);
}
