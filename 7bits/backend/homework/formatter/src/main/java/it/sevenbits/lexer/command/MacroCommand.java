package it.sevenbits.lexer.command;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Macro command.
 */
public class MacroCommand implements ICommand, IMacroCommand {
    private List<ICommand> commands;

    /**
     * Instantiates a new Macro command.
     */
    public MacroCommand() {
        commands = new ArrayList<>();

    }

    @Override
    public void execute() {
        for (ICommand command : commands) {
            command.execute();
        }
    }

    @Override
    public void addNewCommand(final ICommand command) {
        this.commands.add(command);
    }
}
