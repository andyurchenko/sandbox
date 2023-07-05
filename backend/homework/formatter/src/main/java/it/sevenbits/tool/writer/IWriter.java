package it.sevenbits.tool.writer;

/**
 * The interface Writer.
 */
public interface IWriter extends AutoCloseable {
    /**
     * Write.
     *
     * @param whatToWrite the what to write
     */
    void write(String whatToWrite);

    /**
     * Close writer.
     */
    void closeWriter();
}
