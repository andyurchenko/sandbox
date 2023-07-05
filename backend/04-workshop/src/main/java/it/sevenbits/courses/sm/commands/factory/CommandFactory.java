package it.sevenbits.courses.sm.commands.factory;

import it.sevenbits.courses.sm.commands.INetworkManagerCommand;
import it.sevenbits.courses.sm.manager.messages.MessageManager;
import it.sevenbits.courses.sm.manager.network.sm.Pair;
import it.sevenbits.courses.sm.network.INetworkPackage;

/**
 * The type Command factory.
 */
public class CommandFactory implements ICommandFactory {
    private final CommandRepository commandRepository;
    private final MessageManager messageManager;

    /**
     * Instantiates a new Command factory.
     */
    public CommandFactory() {
        this.messageManager = new MessageManager();
        this.commandRepository = new CommandRepository(messageManager);
    }

    @Override
    public INetworkManagerCommand getCommand(final String state, final INetworkPackage networkPackage) {
        messageManager.setMessage(networkPackage.getMessage());
        return this.commandRepository.commands.get(new Pair(state, networkPackage.getType()));
    }
}
