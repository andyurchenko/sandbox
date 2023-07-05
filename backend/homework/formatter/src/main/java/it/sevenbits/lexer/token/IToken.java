package it.sevenbits.lexer.token;

/**
 * The interface Token.
 */
public interface IToken {
    /**
     * Gets lexeme type.
     *
     * @return the lexeme type
     */
    String getLexemeType();

    /**
     * Gets lexeme value.
     *
     * @return the lexeme value
     */
    String getLexemeValue();
}
