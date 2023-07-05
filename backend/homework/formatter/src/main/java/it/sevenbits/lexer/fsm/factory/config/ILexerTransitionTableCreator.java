package it.sevenbits.lexer.fsm.factory.config;

import it.sevenbits.lexer.fsm.LexerEvent;
import it.sevenbits.lexer.fsm.LexerState;

import java.util.Map;

/**
 * The interface Lexer transition table creator.
 */
public interface ILexerTransitionTableCreator {
    /**
     * Create map.
     *
     * @param jsonString the json string
     * @return the map
     */
    Map<LexerState, Map<LexerEvent, LexerState>> create(String jsonString);
}
