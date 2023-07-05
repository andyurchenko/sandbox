package it.sevenbits.formatter.command;

import it.sevenbits.formatter.IFormatterDataAccess;

/**
 * The type Command write token.
 */
public class CommandWriteToken implements ICommand {
    private IFormatterDataAccess formatter;

    /**
     * Instantiates a new Command write token.
     *
     * @param formatter the formatter
     */
    public CommandWriteToken(final IFormatterDataAccess formatter) {
        this.formatter = formatter;
    }

    @Override
    public void execute() {
        this.formatter.writeStringTo(this.formatter.getCurrentToken().getLexemeValue());
    }
}
