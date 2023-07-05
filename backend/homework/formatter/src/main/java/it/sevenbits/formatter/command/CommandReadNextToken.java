package it.sevenbits.formatter.command;

import it.sevenbits.formatter.IFormatterDataAccess;

/**
 * The type Command read next token.
 */
public class CommandReadNextToken implements ICommand {

    private IFormatterDataAccess formatter;

    /**
     * Instantiates a new Command read next token.
     *
     * @param formatter the formatter
     */
    public CommandReadNextToken(final IFormatterDataAccess formatter) {
        this.formatter = formatter;
    }

    @Override
    public void execute() {
        this.formatter.readNextToken();
    }
}
