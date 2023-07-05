package it.sevenbits.formatter.command;

import it.sevenbits.formatter.IFormatterDataAccess;

/**
 * The type Command delete indent before the mark.
 */
public class CommandDeleteIndentBeforeTheMark implements ICommand {
    private IFormatterDataAccess formatter;

    /**
     * Instantiates a new Command delete indent before the mark.
     *
     * @param formatter the formatter
     */
    public CommandDeleteIndentBeforeTheMark(final IFormatterDataAccess formatter) {
        this.formatter = formatter;
    }

    @Override
    public void execute() {
        this.formatter.deleteIndentBeforeTheMark();
    }
}
