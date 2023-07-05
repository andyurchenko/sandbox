package it.sevenbits.directory.analyzer.file.tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

/**
 * The type Writer to file.
 */
public class WriterToFile implements IWriterToFile {
    private BufferedWriter bufferedWriter;
    private int currentCountOfRecords;

    private final int bufferSizeForRecords;

    /**
     * Instantiates a new Writer to file.
     *
     * @param fileName   the file name
     * @param bufferSize the buffer size
     */
    public WriterToFile(final String fileName, final int bufferSize) {
        this.currentCountOfRecords = 0;
        this.bufferSizeForRecords = bufferSize;
        File fileToWriteTo = FileTools.createFile(fileName);
        this.bufferedWriter = FileTools.createBufferedWriter(fileToWriteTo);
    }

    /**
     * Writes records to file.
     *
     * @param recordToWrite   the record to write to file
     */
    public void writeToFile(final String recordToWrite) {
        try {
            this.bufferedWriter.write(recordToWrite);
            this.currentCountOfRecords++;
            if (this.currentCountOfRecords == bufferSizeForRecords) {
                this.bufferedWriter.flush();
                this.currentCountOfRecords = 0;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *Close  Writer to file.
     *
     *
     */
    public void closeWriter() {
        try {
            this.bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
