package it.sevenbits.formatter.command;

import it.sevenbits.formatter.IFormatterDataAccess;

/**
 * The type Command delete standard indent size from buffer.
 */
public class CommandDeleteStandardIndentSizeFromBuffer implements ICommand {
    private IFormatterDataAccess formatter;

    /**
     * Instantiates a new Command delete standard indent size from buffer.
     *
     * @param formatter the formatter
     */
    public CommandDeleteStandardIndentSizeFromBuffer(final IFormatterDataAccess formatter) {
        this.formatter = formatter;
    }

    @Override
    public void execute() {
        formatter.deleteStandardIndentSizeFromBuffer();
    }
}
