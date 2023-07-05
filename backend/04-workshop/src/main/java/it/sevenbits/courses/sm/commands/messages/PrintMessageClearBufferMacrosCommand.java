package it.sevenbits.courses.sm.commands.messages;

import it.sevenbits.courses.sm.commands.INetworkManagerCommand;

/**
 * The type Print message clear buffer macros command.
 */
public class PrintMessageClearBufferMacrosCommand implements INetworkManagerCommand {
    private INetworkManagerCommand[] commands;

    /**
     * Instantiates a new Print message clear buffer macros command.
     *
     * @param commands the commands
     */
    public PrintMessageClearBufferMacrosCommand(final INetworkManagerCommand[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (int i = 0; i < commands.length; i++) {
            commands[i].execute();
        }
    }
}
