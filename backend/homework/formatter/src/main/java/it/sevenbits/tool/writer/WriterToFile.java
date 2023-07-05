package it.sevenbits.tool.writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;

/**
 * The type Writer to file.
 */
public class WriterToFile implements IWriter {
    private FileWriter fileWriter;
    private final Logger logger;

    /**
     * Instantiates a new Writer to file.
     *
     * @param pathToFile the path to file
     */
    public WriterToFile(final String pathToFile) {
        logger = LoggerFactory.getLogger(WriterToFile.class);
        try {
            fileWriter = new FileWriter(pathToFile);
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Override
    public void write(final String str) {
        try {
            fileWriter.write(str);
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Override
    public void closeWriter() {
        try {
            fileWriter.close();
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Override
    public void close()  {
        try {
            fileWriter.close();
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }
}
