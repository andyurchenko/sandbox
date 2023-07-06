package it.sevenbits.tool.reader;

/**
 * The interface Whole file reader.
 */
public interface IWholeFileReader {
    /**
     * Read file string.
     *
     * @param pathToFile the path to file
     * @return the string
     * @throws IllegalArgumentException the illegal argument exception
     */
    String readFile(String pathToFile) throws IllegalArgumentException;
}
