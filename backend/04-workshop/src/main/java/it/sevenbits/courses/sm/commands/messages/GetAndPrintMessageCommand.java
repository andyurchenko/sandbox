package it.sevenbits.courses.sm.commands.messages;

import it.sevenbits.courses.sm.commands.INetworkManagerCommand;
import it.sevenbits.courses.sm.manager.messages.IMessageManager;

/**
 * The type Get and print message command.
 */
public class GetAndPrintMessageCommand implements INetworkManagerCommand {
    private final IMessageManager messageManager;

    /**
     * Instantiates a new Get and print message command.
     *
     * @param messageManager the message manager
     */
    public GetAndPrintMessageCommand(final IMessageManager messageManager) {
        this.messageManager = messageManager;
    }
    @Override
    public void execute() {
        System.out.println("Result message is : " + messageManager.getMessageFromBuffer());
    }
}
