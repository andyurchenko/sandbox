package it.sevenbits.tool.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * The type Reader from file.
 */
public class ReaderFromFile implements IReader {

    private BufferedReader bufferedReader;
    private int bufferedChar;
    private boolean nextCharIsAvailable;
    private static final int EOF = -1;
    private final Logger logger;

    /**
     * Instantiates a new Reader from file.
     *
     * @param pathToFile the path to file
     */
    public ReaderFromFile(final String pathToFile) {
        logger = LoggerFactory.getLogger(ReaderFromFile.class);

        try {
            bufferedReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(pathToFile), StandardCharsets.UTF_8));
        } catch (FileNotFoundException ex) {
            logger.error(ex.getMessage());
        }

        try {
            this.bufferedChar = this.bufferedReader.read();

            if (isEOF(this.bufferedChar)) {
                this.nextCharIsAvailable = false;
            } else {
                this.nextCharIsAvailable = true;
            }

        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Override
    public boolean hasNext() {
        return this.nextCharIsAvailable;
    }

    @Override
    public char readNextCharacter() {
        int charToReturn = this.bufferedChar;

        try {
            this.bufferedChar = this.bufferedReader.read();
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }

        if (isEOF(charToReturn) && isEOF(bufferedChar)) {
            nextCharIsAvailable = false;
        }

        return (char) charToReturn;
    }

    @Override
    public void close() {
        try {
            bufferedReader.close();
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }

    }

    private boolean isEOF(final int inCharToCheck) {
        return inCharToCheck == EOF;
    }
}
