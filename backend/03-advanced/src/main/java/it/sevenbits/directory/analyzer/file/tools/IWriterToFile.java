package it.sevenbits.directory.analyzer.file.tools;

/**
 * The interface Writer to file.
 */
public interface IWriterToFile {
    /**
     * Write to file.
     *
     * @param recordToWrite the record to write
     */
    void writeToFile(String recordToWrite);

    /**
     * Close writer.
     */
    void closeWriter();
}
