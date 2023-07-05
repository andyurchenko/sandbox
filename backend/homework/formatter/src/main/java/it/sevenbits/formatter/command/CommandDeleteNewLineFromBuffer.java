package it.sevenbits.formatter.command;

import it.sevenbits.formatter.IFormatterDataAccess;

/**
 * The type Command delete new line from buffer.
 */
public class CommandDeleteNewLineFromBuffer implements ICommand {
    private IFormatterDataAccess formatter;

    /**
     * Instantiates a new Command delete new line from buffer.
     *
     * @param formatter the formatter
     */
    public CommandDeleteNewLineFromBuffer(final IFormatterDataAccess formatter) {
        this.formatter = formatter;
    }

    @Override
    public void execute() {
        this.formatter.deleteNewLineFromBuffer();
    }
}
