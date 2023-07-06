package it.sevenbits.formatter.fsm.factory.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import it.sevenbits.formatter.fsm.FormatterEvent;
import it.sevenbits.formatter.fsm.FormatterState;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * The type Formatter transition table creator.
 */
public class FormatterTransitionTableCreator implements IFormatterTransitionTableCreator {

    @Override
    public Map<FormatterState, Map<FormatterEvent, FormatterState>> create(final String jsonString) {
        Type type = new TypeToken<Map<FormatterState, Map<FormatterEvent, FormatterState>>>() { }.getType();
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        return gson.fromJson(jsonString, type);
    }
}
