package it.sevenbits.lexer;

import it.sevenbits.lexer.token.IToken;

/**
 * The interface Lexer.
 */
public interface ILexer {
    /**
     * Has more tokens boolean.
     *
     * @return the boolean
     */
    boolean hasMoreTokens();

    /**
     * Gets next token.
     *
     * @return the next token
     */
    IToken getNextToken();
}
