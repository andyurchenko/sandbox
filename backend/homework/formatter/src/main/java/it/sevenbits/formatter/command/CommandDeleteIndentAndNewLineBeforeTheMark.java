package it.sevenbits.formatter.command;

import it.sevenbits.formatter.IFormatterDataAccess;

/**
 * The type Command delete indent and new line before the mark.
 */
public class CommandDeleteIndentAndNewLineBeforeTheMark implements ICommand {
    private IFormatterDataAccess formatter;

    /**
     * Instantiates a new Command delete indent and new line before the mark.
     *
     * @param formatter the formatter
     */
    public CommandDeleteIndentAndNewLineBeforeTheMark(final IFormatterDataAccess formatter) {
        this.formatter = formatter;
    }

    @Override
    public void execute() {
        this.formatter.deleteIndentAndNewLineBeforeTheMark();
    }
}
