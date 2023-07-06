package it.sevenbits.formatter.command;

import it.sevenbits.formatter.IFormatterDataAccess;

/**
 * The type Command delete current indent size from buffer.
 */
public class CommandDeleteCurrentIndentSizeFromBuffer implements ICommand {
    private IFormatterDataAccess formatter;

    /**
     * Instantiates a new Command delete current indent size from buffer.
     *
     * @param formatter the formatter
     */
    public CommandDeleteCurrentIndentSizeFromBuffer(final IFormatterDataAccess formatter) {
        this.formatter = formatter;
    }

    @Override
    public void execute() {
        formatter.deleteCurrentIndentSizeFromBuffer();
    }
}
