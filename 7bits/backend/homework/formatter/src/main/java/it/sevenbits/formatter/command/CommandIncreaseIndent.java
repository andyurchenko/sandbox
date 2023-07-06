package it.sevenbits.formatter.command;

import it.sevenbits.formatter.IFormatterDataAccess;

/**
 * The type Command increase indent.
 */
public class CommandIncreaseIndent implements ICommand {
    private IFormatterDataAccess formatter;

    /**
     * Instantiates a new Command increase indent.
     *
     * @param formatter the formatter
     */
    public CommandIncreaseIndent(final IFormatterDataAccess formatter) {
        this.formatter = formatter;
    }

    @Override
    public void execute() {
        this.formatter.increaseIndent();
    }
}
