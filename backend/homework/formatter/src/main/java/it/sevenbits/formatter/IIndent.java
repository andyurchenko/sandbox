package it.sevenbits.formatter;

/**
 * The interface Indent.
 */
public interface IIndent {
    /**
     * Increase indent size.
     */
    void increaseIndentSize();

    /**
     * Decrease indent size.
     */
    void decreaseIndentSize();

    /**
     * Gets indent.
     *
     * @return the indent
     */
    String getIndent();

    /**
     * Gets indent standard size.
     *
     * @return the indent standard size
     */
    int getIndentStandardSize();

    /**
     * Gets current indent size.
     *
     * @return the current indent size
     */
    int getCurrentIndentSize();
}
