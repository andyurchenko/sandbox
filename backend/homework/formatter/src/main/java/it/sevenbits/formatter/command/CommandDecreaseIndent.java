package it.sevenbits.formatter.command;

import it.sevenbits.formatter.IFormatterDataAccess;

/**
 * The type Command decrease indent.
 */
public class CommandDecreaseIndent implements ICommand {
    private IFormatterDataAccess formatter;

    /**
     * Instantiates a new Command decrease indent.
     *
     * @param formatter the formatter
     */
    public CommandDecreaseIndent(final IFormatterDataAccess formatter) {
        this.formatter = formatter;
    }

    @Override
    public void execute() {
        this.formatter.decreaseIndent();
    }
}
