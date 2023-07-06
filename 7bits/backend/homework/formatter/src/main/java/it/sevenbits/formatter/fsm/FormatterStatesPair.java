package it.sevenbits.formatter.fsm;


import java.util.Objects;

/**
 * The type Formatter states pair.
 */
public class FormatterStatesPair {
    private FormatterState currentFormatterState;
    private FormatterState nextFormatterState;

    /**
     * Instantiates a new Formatter states pair.
     *
     * @param currentFormatterState the current formatter state
     * @param nextFormatterState    the next formatter state
     */
    public FormatterStatesPair(final FormatterState currentFormatterState, final FormatterState nextFormatterState) {
        this.currentFormatterState = currentFormatterState;
        this.nextFormatterState = nextFormatterState;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FormatterStatesPair that = (FormatterStatesPair) o;
        return Objects.equals(currentFormatterState, that.currentFormatterState) && Objects.equals(nextFormatterState, that.nextFormatterState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentFormatterState, nextFormatterState);
    }
}
