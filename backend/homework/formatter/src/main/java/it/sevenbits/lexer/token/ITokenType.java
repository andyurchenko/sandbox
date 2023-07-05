package it.sevenbits.lexer.token;

/**
 * The interface Token type.
 */
public interface ITokenType {
    /**
     * Gets token type.
     *
     * @param currentState the current state
     * @param tokenValue   the token value
     * @return the token type
     */
    String getTokenType(String currentState, String tokenValue);
}
