package it.sevenbits.formatter.command;

import it.sevenbits.formatter.IFormatterDataAccess;

/**
 * The type Command formatter default.
 */
public class CommandFormatterDefault implements ICommand {

    private IFormatterDataAccess formatter;

    /**
     * Instantiates a new Command formatter default.
     *
     * @param formatter the formatter
     */
    public CommandFormatterDefault(final IFormatterDataAccess formatter) {
        this.formatter = formatter;
    }

    @Override
    public void execute() {
    }
}
