package it.sevenbits.lexer.command.factory;

import it.sevenbits.lexer.ILexerDataAccess;
import it.sevenbits.lexer.command.ICommand;

/**
 * The interface Lexer command factory.
 */
public interface ILexerCommandFactory {
    /**
     * Gets command.
     *
     * @return the command
     */
    ICommand getCommand();

    /**
     * Sets lexer.
     *
     * @param lexerDataAccess the lexer data access
     */
    void setLexer(ILexerDataAccess lexerDataAccess);
}
