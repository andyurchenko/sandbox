package it.sevenbits.lexer.token;

import it.sevenbits.lexer.token.IToken;

/**
 * The interface Token pool.
 */
public interface ITokenPool {
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

    /**
     * Add new token.
     *
     * @param tokenToAdd the token to add
     */
    void addNewToken(IToken tokenToAdd);
}
