package it.sevenbits.formatter.command;

import it.sevenbits.formatter.IFormatterDataAccess;

/**
 * The type Command write new line.
 */
public class CommandWriteNewLine implements ICommand {
    private IFormatterDataAccess formatter;

    /**
     * Instantiates a new Command write new line.
     *
     * @param formatter the formatter
     */
    public CommandWriteNewLine(final IFormatterDataAccess formatter) {
        this.formatter = formatter;
    }

    @Override
    public void execute() {
        this.formatter.writeStringTo("\n");
    }
}
