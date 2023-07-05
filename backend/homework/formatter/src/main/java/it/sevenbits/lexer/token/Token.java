package it.sevenbits.lexer.token;

/**
 * The type Token.
 */
public class Token implements IToken {
    private String lexemeType;
    private String lexemeValue;

    /**
     * Instantiates a new Token.
     *
     * @param lexemeType  the lexeme type
     * @param lexemeValue the lexeme value
     */
    public Token(final String lexemeType, final String lexemeValue) {
        this.lexemeType = lexemeType;
        this.lexemeValue = lexemeValue;
    }

    @Override
    public String getLexemeType() {
        return this.lexemeType;
    }

    @Override
    public String getLexemeValue() {
        return this.lexemeValue;
    }

    @Override
    public String toString() {
        return lexemeType + ", " + lexemeValue + "   ";
    }
}
