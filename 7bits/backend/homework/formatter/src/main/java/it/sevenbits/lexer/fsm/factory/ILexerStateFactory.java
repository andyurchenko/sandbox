package it.sevenbits.lexer.fsm.factory;

import it.sevenbits.lexer.fsm.LexerState;

/**
 * The interface Lexer state factory.
 */
public interface ILexerStateFactory {
    /**
     * Gets next state.
     *
     * @param currentLexerState the current lexer state
     * @param currentChar       the current char
     * @return the next state
     */
    LexerState getNextState(LexerState currentLexerState, String currentChar);

    /**
     * Gets start state.
     *
     * @return the start state
     */
    LexerState getStartState();
}
