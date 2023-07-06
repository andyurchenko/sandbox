package it.sevenbits.formatter.command;

import it.sevenbits.formatter.IFormatterDataAccess;

/**
 * The type Command add new line to buffer.
 */
public class CommandAddNewLineToBuffer implements ICommand {
    private IFormatterDataAccess formatter;

    /**
     * Instantiates a new Command add new line to buffer.
     *
     * @param formatter the formatter
     */
    public CommandAddNewLineToBuffer(final IFormatterDataAccess formatter) {
        this.formatter = formatter;
    }

    @Override
    public void execute() {
        this.formatter.addToBuffer("\n");
    }
}
