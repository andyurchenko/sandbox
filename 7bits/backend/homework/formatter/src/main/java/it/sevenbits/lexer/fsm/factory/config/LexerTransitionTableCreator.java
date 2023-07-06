package it.sevenbits.lexer.fsm.factory.config;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import it.sevenbits.lexer.fsm.LexerEvent;
import it.sevenbits.lexer.fsm.LexerState;

//import java.io.*;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * The type Lexer transition table creator.
 */
public class LexerTransitionTableCreator implements ILexerTransitionTableCreator {

    @Override
    public Map<LexerState, Map<LexerEvent, LexerState>> create(final String jsonString) {
        Type type = new TypeToken<Map<LexerState, Map<LexerEvent, LexerState>>>() { }.getType();
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        return gson.fromJson(jsonString, type);
    }
}
