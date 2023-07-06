package it.sevenbits.formatter.command;

import it.sevenbits.formatter.IFormatterDataAccess;

/**
 * The type Command set mark to the next position to add.
 */
public class CommandSetMarkToTheNextPositionToAdd implements ICommand {
    private IFormatterDataAccess formatter;

    /**
     * Instantiates a new Command set mark to the next position to add.
     *
     * @param formatter the formatter
     */
    public CommandSetMarkToTheNextPositionToAdd(final IFormatterDataAccess formatter) {
        this.formatter = formatter;
    }

    @Override
    public void execute() {
        this.formatter.setMarkToTheNextPositionToAdd();
    }
}
