package it.sevenbits.formatter.command.factory;


import it.sevenbits.formatter.IFormatterDataAccess;
import it.sevenbits.formatter.command.ICommand;

/**
 * The interface Formatter command factory.
 */
public interface IFormatterCommandFactory {
    /**
     * Gets command.
     *
     * @return the command
     */
    ICommand getCommand();

    /**
     * Sets formatter.
     *
     * @param formatter the formatter
     */
    void setFormatter(IFormatterDataAccess formatter);
}
