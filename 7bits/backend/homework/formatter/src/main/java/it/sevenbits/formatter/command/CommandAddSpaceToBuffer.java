package it.sevenbits.formatter.command;

import it.sevenbits.formatter.IFormatterDataAccess;

/**
 * The type Command add space to buffer.
 */
public class CommandAddSpaceToBuffer implements ICommand {
    private IFormatterDataAccess formatter;

    /**
     * Instantiates a new Command add space to buffer.
     *
     * @param formatter the formatter
     */
    public CommandAddSpaceToBuffer(final IFormatterDataAccess formatter) {
        this.formatter = formatter;
    }

    @Override
    public void execute() {
        this.formatter.addToBuffer(" ");
    }
}
