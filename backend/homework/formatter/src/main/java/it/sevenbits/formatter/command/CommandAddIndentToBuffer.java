package it.sevenbits.formatter.command;

import it.sevenbits.formatter.IFormatterDataAccess;

/**
 * The type Command add indent to buffer.
 */
public class CommandAddIndentToBuffer implements ICommand {
    private IFormatterDataAccess formatter;

    /**
     * Instantiates a new Command add indent to buffer.
     *
     * @param formatter the formatter
     */
    public CommandAddIndentToBuffer(final IFormatterDataAccess formatter) {
        this.formatter = formatter;
    }

    @Override
    public void execute() {
        this.formatter.addToBuffer(this.formatter.getIndent().getIndent());
    }
}
