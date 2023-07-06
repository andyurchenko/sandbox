package it.sevenbits.logger.concrete;

import it.sevenbits.logger.ILogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Logger slf 4 j.
 */
public class LoggerSLF4J implements ILogger {

    private final Logger logger;

    /**
     * Instantiates a new Logger slf 4 j.
     *
     * @param name the name
     */
    public LoggerSLF4J(final Class<?> name) {
        this.logger = LoggerFactory.getLogger(name);
    }

    @Override
    public void trace(final String messageToLog) {
        logger.trace(messageToLog);
    }

    @Override
    public void debug(final String messageToLog) {
        logger.debug(messageToLog);
    }

    @Override
    public void info(final String messageToLog) {
        logger.info(messageToLog);
    }

    @Override
    public void warn(final String messageToLog) {
        logger.warn(messageToLog);
    }

    @Override
    public void error(final String messageToLog) {
        logger.error(messageToLog);
    }
}
