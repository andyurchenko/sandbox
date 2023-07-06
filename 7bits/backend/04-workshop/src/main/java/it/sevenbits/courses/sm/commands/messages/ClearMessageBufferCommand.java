package it.sevenbits.courses.sm.commands.messages;

import it.sevenbits.courses.sm.commands.INetworkManagerCommand;
import it.sevenbits.courses.sm.manager.messages.IMessageManager;

/**
 * The type Clear message buffer command.
 */
public class ClearMessageBufferCommand implements INetworkManagerCommand {
    private IMessageManager messageManager;

    /**
     * Instantiates a new Clear message buffer command.
     *
     * @param messageManager the message manager
     */
    public ClearMessageBufferCommand(final IMessageManager messageManager) {
        this.messageManager = messageManager;
    }

    @Override
    public void execute() {
        this.messageManager.clearBuffer();
    }
}
