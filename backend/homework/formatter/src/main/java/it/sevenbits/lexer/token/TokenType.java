package it.sevenbits.lexer.token;

import it.sevenbits.lexer.token.reader.IConfigReaderForTokenType;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Token type.
 */
public class TokenType implements ITokenType {

    private final Map<Map<String, String>, String> mapTokenType;
    private IConfigReaderForTokenType configReader;

    /**
     * Instantiates a new Token type.
     *
     * @param configReader the config reader
     */
    public TokenType(final IConfigReaderForTokenType configReader) {
        this.configReader = configReader;
        mapTokenType = this.configReader.getTokenTypeTable();
    }

    @Override
    public String getTokenType(final String currentState, final String tokenValue) {
        Map<String, String> tokenStateValuePair = new HashMap<>();
        tokenStateValuePair.put(currentState, tokenValue);
        String tokenTypeToReturn = this.mapTokenType.get(tokenStateValuePair);
        if (tokenTypeToReturn == null) {
            return currentState;
        } else {
            return tokenTypeToReturn;
        }
    }
}
