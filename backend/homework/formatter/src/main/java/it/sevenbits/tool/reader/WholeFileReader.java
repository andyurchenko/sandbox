package it.sevenbits.tool.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * The type Whole file reader.
 */
public class WholeFileReader implements IWholeFileReader {
    private final Logger logger;

    /**
     * Instantiates a new Whole file reader.
     */
    public WholeFileReader() {
        logger = LoggerFactory.getLogger(WholeFileReader.class);
    }

    @Override
    public String readFile(final String pathToFile) {
        InputStream ioStream = this.getClass().getClassLoader().getResourceAsStream(pathToFile);

        if (ioStream == null) {
            throw new IllegalArgumentException(pathToFile + " is not found");
        }

        StringBuilder sb = new StringBuilder();
        try (InputStreamReader isr = new InputStreamReader(ioStream); BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            ioStream.close();
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }

        try {
            ioStream.close();
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }

        return sb.toString();
    }
}
