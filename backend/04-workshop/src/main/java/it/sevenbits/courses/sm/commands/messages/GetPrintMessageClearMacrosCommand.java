package it.sevenbits.courses.sm.commands.messages;

import it.sevenbits.courses.sm.commands.INetworkManagerCommand;

/**
 * The type Get print message clear macros command.
 */
public class GetPrintMessageClearMacrosCommand implements INetworkManagerCommand {
    private INetworkManagerCommand[] commands;

    /**
     * Instantiates a new Get print message clear macros command.
     *
     * @param commands the commands
     */
    public GetPrintMessageClearMacrosCommand(final INetworkManagerCommand[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (int i = 0; i < commands.length; i++) {
            commands[i].execute();
        }
    }
}
