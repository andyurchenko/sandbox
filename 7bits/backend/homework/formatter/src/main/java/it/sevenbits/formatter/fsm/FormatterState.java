package it.sevenbits.formatter.fsm;

import java.util.Objects;

/**
 * The type Formatter state.
 */
public class FormatterState {
    private String stateName;

    /**
     * Instantiates a new Formatter state.
     *
     * @param stateName the state name
     */
    public FormatterState(final String stateName) {
        this.stateName = stateName;
    }

    /**
     * Instantiates a new Formatter state.
     */
    public FormatterState() {
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
        FormatterState formatterState = (FormatterState) o;
        return Objects.equals(stateName, formatterState.stateName);
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
