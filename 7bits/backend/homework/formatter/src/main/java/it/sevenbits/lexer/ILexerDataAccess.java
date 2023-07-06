package it.sevenbits.lexer;

import it.sevenbits.lexer.fsm.LexerState;

/**
 * The interface Lexer data access.
 */
public interface ILexerDataAccess {
    /**
     * Gets current character.
     *
     * @return the current character
     */
    String getCurrentCharacter();

    /**
     * Add to current char buffer.
     */
    void addToCurrentCharBuffer();

    /**
     * Gets current state.
     *
     * @return the current state
     */
    LexerState getCurrentState();

    /**
     * Gets next state.
     *
     * @return the next state
     */
    LexerState getNextState();

    /**
     * Clear buffer.
     */
    void clearBuffer();

    /**
     * Read next character.
     */
    void readNextCharacter();

    /**
     * Create new token from buffer.
     */
    void createNewTokenFromBuffer();

    /**
     * Create new token from current character.
     */
    void createNewTokenFromCurrentCharacter();
}
