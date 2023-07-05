package it.sevenbits.lexer.fsm.factory;

import it.sevenbits.lexer.fsm.LexerEvent;
import it.sevenbits.lexer.fsm.LexerState;

import java.util.Map;

/**
 * The type Lexer state factory.
 */
public class LexerStateFactory implements ILexerStateFactory {
    private Map<LexerState, Map<LexerEvent, LexerState>> stateTransitionTable;

    private final LexerState startLexerState;
    private Map<LexerEvent, LexerState> eventStateTransitionTable;


    /**
     * Instantiates a new Lexer state factory.
     *
     * @param stateTransitionTable the state transition table
     * @param startState           the start state
     */
    public LexerStateFactory(final Map<LexerState, Map<LexerEvent, LexerState>> stateTransitionTable, final String startState) {
        this.stateTransitionTable = stateTransitionTable;
        this.startLexerState = new LexerState(startState);
    }

    /**
     * Get next state.
     * @param currentChar current event in FSM
     * @param currentLexerState current FSM state
     * @return next state for FSM
     */
    public LexerState getNextState(final LexerState currentLexerState, final String currentChar) {
        getEventNextStateTransitionTableForGivenState(currentLexerState);
        return getNextStateForGivenEvent(currentChar);
    }

    private void getEventNextStateTransitionTableForGivenState(final LexerState currentLexerState) {
        this.eventStateTransitionTable = this.stateTransitionTable.get(currentLexerState);
    }

    private LexerState getNextStateForGivenEvent(final String currentChar) {
        return eventStateTransitionTable.getOrDefault(new LexerEvent(currentChar), this.startLexerState);
    }

    @Override
    public LexerState getStartState() {
        return this.startLexerState;
    }
}
