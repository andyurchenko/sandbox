package it.sevenbits.courses.sm.commands.messages;

import it.sevenbits.courses.sm.commands.INetworkManagerCommand;
import it.sevenbits.courses.sm.manager.messages.IMessageManager;

/**
 * The type Print message command.
 */
public class PrintMessageCommand implements INetworkManagerCommand {
    private final IMessageManager messageManager;

    /**
     * Instantiates a new Print message command.
     *
     * @param messageManager the message manager
     */
    public PrintMessageCommand(final IMessageManager messageManager) {
        this.messageManager = messageManager;
    }
    @Override
    public void execute() {
        System.out.println("Result message is : " + messageManager.getMessageFromBuffer());
    }
}
