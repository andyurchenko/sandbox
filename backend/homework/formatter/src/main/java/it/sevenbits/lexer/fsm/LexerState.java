package it.sevenbits.lexer.fsm;

import java.util.Objects;

/**
 * The type Lexer state.
 */
public class LexerState {
    private String stateName;

    /**
     * Instantiates a new Lexer state.
     *
     * @param stateName the state name
     */
    public LexerState(final String stateName) {
        this.stateName = stateName;
    }

    /**
     * Instantiates a new Lexer state.
     */
    public LexerState() {
    }

    /**
     * Gets state name.
     *
     * @return the state name
     */
    public String getStateName() {
        return stateName;
    }

    /**
     * Sets state name.
     *
     * @param stateName the state name
     */
    public void setStateName(final String stateName) {
        this.stateName = stateName;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LexerState lexerState = (LexerState) o;
        return Objects.equals(stateName, lexerState.stateName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stateName);
    }

    @Override
    public String toString() {
        return stateName;
    }
}
