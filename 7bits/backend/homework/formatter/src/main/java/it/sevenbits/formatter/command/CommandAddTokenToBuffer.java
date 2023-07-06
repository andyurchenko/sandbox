package it.sevenbits.formatter.command;

import it.sevenbits.formatter.IFormatterDataAccess;

/**
 * The type Command add token to buffer.
 */
public class CommandAddTokenToBuffer implements ICommand {
    private IFormatterDataAccess formatter;

    /**
     * Instantiates a new Command add token to buffer.
     *
     * @param formatter the formatter
     */
    public CommandAddTokenToBuffer(final IFormatterDataAccess formatter) {
        this.formatter = formatter;
    }

    @Override
    public void execute() {
        this.formatter.addToBuffer(this.formatter.getCurrentToken().getLexemeValue());
    }
}
