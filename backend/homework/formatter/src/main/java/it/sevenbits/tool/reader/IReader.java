package it.sevenbits.tool.reader;

/**
 * The interface Reader.
 */
public interface IReader extends AutoCloseable {
    /**
     * Has next boolean.
     *
     * @return the boolean
     */
    boolean hasNext();

    /**
     * Read next character char.
     *
     * @return the char
     */
    char readNextCharacter();

}
