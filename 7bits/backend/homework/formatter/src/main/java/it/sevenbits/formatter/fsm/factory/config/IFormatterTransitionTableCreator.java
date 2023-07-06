package it.sevenbits.formatter.fsm.factory.config;


import it.sevenbits.formatter.fsm.FormatterEvent;
import it.sevenbits.formatter.fsm.FormatterState;

import java.util.Map;

/**
 * The interface Formatter transition table creator.
 */
public interface IFormatterTransitionTableCreator {
    /**
     * Create map.
     *
     * @param jsonString the json string
     * @return the map
     */
    Map<FormatterState, Map<FormatterEvent, FormatterState>> create(String jsonString);
}
