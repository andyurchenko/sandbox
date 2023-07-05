package it.sevenbits.formatter.command;

import it.sevenbits.formatter.IFormatterDataAccess;

/**
 * The type Command write buffer.
 */
public class CommandWriteBuffer implements ICommand {
    private IFormatterDataAccess formatter;

    /**
     * Instantiates a new Command write buffer.
     *
     * @param formatter the formatter
     */
    public CommandWriteBuffer(final IFormatterDataAccess formatter) {
        this.formatter = formatter;
    }

    @Override
    public void execute() {
        this.formatter.writeBuffer();
    }
}
