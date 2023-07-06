package it.sevenbits.lexer.token.reader;

import java.util.Map;

/**
 * The interface Config reader for token type.
 */
public interface IConfigReaderForTokenType {
    /**
     * Gets token type table.
     *
     * @return the token type table
     */
    Map<Map<String, String>, String> getTokenTypeTable();
}
