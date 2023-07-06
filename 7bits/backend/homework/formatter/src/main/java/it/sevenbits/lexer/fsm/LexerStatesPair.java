package it.sevenbits.lexer.fsm;

import java.util.Objects;

/**
 * The type Lexer states pair.
 */
public class LexerStatesPair {
    private LexerState currentLexerState;
    private LexerState nextLexerState;

    /**
     * Instantiates a new Lexer states pair.
     *
     * @param currentLexerState the current lexer state
     * @param nextLexerState    the next lexer state
     */
    public LexerStatesPair(final LexerState currentLexerState, final LexerState nextLexerState) {
        this.currentLexerState = currentLexerState;
        this.nextLexerState = nextLexerState;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LexerStatesPair states = (LexerStatesPair) o;
        return Objects.equals(currentLexerState, states.currentLexerState) && Objects.equals(nextLexerState, states.nextLexerState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentLexerState, nextLexerState);
    }
}
