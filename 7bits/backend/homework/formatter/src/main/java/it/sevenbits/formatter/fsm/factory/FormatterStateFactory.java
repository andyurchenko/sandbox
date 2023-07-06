package it.sevenbits.formatter.fsm.factory;

import it.sevenbits.formatter.fsm.FormatterEvent;
import it.sevenbits.formatter.fsm.FormatterState;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Formatter state factory.
 */
public class FormatterStateFactory implements IFormatterStateFactory {
    private final Map<FormatterState, Map<FormatterEvent, FormatterState>> stateTransitionTable;
    private final Map<FormatterState, FormatterState> defaultNextStateForCurrentStateTable;
    private final FormatterState startFormatterState;
    private Map<FormatterEvent, FormatterState> eventStateTransitionTableForGivenState;


    /**
     * Instantiates a new Formatter state factory.
     *
     * @param transitionTable   the transition table
     * @param defaultStateTable the default state table
     * @param startState        the start state
     */
    public FormatterStateFactory(final Map<FormatterState, Map<FormatterEvent, FormatterState>> transitionTable, final Map<FormatterState, FormatterState> defaultStateTable, final String startState) {
        this.stateTransitionTable = transitionTable;
        this.defaultNextStateForCurrentStateTable = defaultStateTable;
        this.startFormatterState = new FormatterState(startState);
    }

    /**
     * Get next state, decision basing on current state and event
     * @param currentFormatterState current FSM state
     * @param formatterEvent event happening in FSM
     * @return next state
     */
    public FormatterState getNextState(final FormatterState currentFormatterState, final FormatterEvent formatterEvent) {
        getEventNextStateTransitionTableForGivenState(currentFormatterState);
        return getNextStateForGivenEvent(formatterEvent, currentFormatterState);
    }

    private void getEventNextStateTransitionTableForGivenState(final FormatterState currentFormatterState) {
        this.eventStateTransitionTableForGivenState = this.stateTransitionTable.getOrDefault(currentFormatterState, new HashMap<>());
    }

    private FormatterState getNextStateForGivenEvent(final FormatterEvent formatterEvent, final FormatterState currentFormatterState) {
        return eventStateTransitionTableForGivenState.getOrDefault(formatterEvent, this.getDefaultNextState(currentFormatterState));
    }

    private FormatterState getDefaultNextState(final FormatterState formatterState) {
        return this.defaultNextStateForCurrentStateTable.getOrDefault(formatterState, this.getStartState());
    }

    @Override
    public FormatterState getStartState() {
        return this.startFormatterState;
    }
}
