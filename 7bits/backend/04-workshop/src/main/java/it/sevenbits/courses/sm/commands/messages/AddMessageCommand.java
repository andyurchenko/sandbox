package it.sevenbits.courses.sm.commands.messages;

import it.sevenbits.courses.sm.commands.INetworkManagerCommand;
import it.sevenbits.courses.sm.manager.messages.IMessageManager;

/**
 * The type Add message command.
 */
public class AddMessageCommand implements INetworkManagerCommand {
    private IMessageManager messageManager;

    /**
     * Instantiates a new Add message command.
     *
     * @param messageManager the message manager
     */
    public AddMessageCommand(final IMessageManager messageManager) {
        this.messageManager = messageManager;
    }

    @Override
    public void execute() {

        this.messageManager.addMessageToBuffer();
    }
}
