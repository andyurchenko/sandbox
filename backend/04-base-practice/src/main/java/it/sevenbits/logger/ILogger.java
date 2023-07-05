package it.sevenbits.logger;

/**
 * The interface Logger.
 */
public interface ILogger {
    /**
     * Trace.
     *
     * @param messageToLog the message to log
     */
    void trace(String messageToLog);

    /**
     * Debug.
     *
     * @param messageToLog the message to log
     */
    void debug(String messageToLog);

    /**
     * Info.
     *
     * @param messageToLog the message to log
     */
    void info(String messageToLog);

    /**
     * Warn.
     *
     * @param messageToLog the message to log
     */
    void warn(String messageToLog);

    /**
     * Error.
     *
     * @param messageToLog the message to log
     */
    void error(String messageToLog);
}
