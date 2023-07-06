package it.sevenbits.formatter.command;

import it.sevenbits.formatter.IFormatterDataAccess;

/**
 * The type Command delete all chars from current position to mark position.
 */
public class CommandDeleteAllCharsFromCurrentPositionToMarkPosition implements ICommand {
    private IFormatterDataAccess formatter;

    /**
     * Instantiates a new Command delete all chars from current position to mark position.
     *
     * @param formatter the formatter
     */
    public CommandDeleteAllCharsFromCurrentPositionToMarkPosition(final IFormatterDataAccess formatter) {
        this.formatter = formatter;
    }

    @Override
    public void execute() {
        this.formatter.deleteAllCharsFromCurrentPositionToMarkPosition();
    }
}
