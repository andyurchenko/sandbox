package it.sevenbits.formatter.fsm.factory;


import it.sevenbits.formatter.fsm.FormatterEvent;
import it.sevenbits.formatter.fsm.FormatterState;

/**
 * The interface Formatter state factory.
 */
public interface IFormatterStateFactory {
    /**
     * Gets next state.
     *
     * @param currentFormatterState the current formatter state
     * @param formatterEvent        the formatter event
     * @return the next state
     */
    FormatterState getNextState(FormatterState currentFormatterState, FormatterEvent formatterEvent);

    /**
     * Gets start state.
     *
     * @return the start state
     */
    FormatterState getStartState();
}
