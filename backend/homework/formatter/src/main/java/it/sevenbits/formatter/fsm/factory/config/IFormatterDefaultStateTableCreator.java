package it.sevenbits.formatter.fsm.factory.config;

import it.sevenbits.formatter.fsm.FormatterState;

import java.util.Map;

/**
 * The interface Formatter default state table creator.
 */
public interface IFormatterDefaultStateTableCreator {
    /**
     * Create map.
     *
     * @param jsonString the json string
     * @return the map
     */
    Map<FormatterState, FormatterState> create(String jsonString);
}
