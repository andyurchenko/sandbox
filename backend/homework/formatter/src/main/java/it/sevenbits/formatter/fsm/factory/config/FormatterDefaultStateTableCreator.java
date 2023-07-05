package it.sevenbits.formatter.fsm.factory.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import it.sevenbits.formatter.fsm.FormatterState;


import java.lang.reflect.Type;
import java.util.Map;

/**
 * The type Formatter default state table creator.
 */
public class FormatterDefaultStateTableCreator implements IFormatterDefaultStateTableCreator {

    @Override
    public Map<FormatterState, FormatterState> create(final String jsonString) {
        Type type = new TypeToken<Map<FormatterState, FormatterState>>() { }.getType();
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        return gson.fromJson(jsonString, type);
    }

}
