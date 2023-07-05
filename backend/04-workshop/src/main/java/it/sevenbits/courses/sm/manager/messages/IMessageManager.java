package it.sevenbits.courses.sm.manager.messages;

/**
 * The interface Message manager.
 */
public interface IMessageManager {
    /**
     * Add message to buffer.
     */
    void addMessageToBuffer();

    /**
     * Gets message from buffer.
     *
     * @return the message from buffer
     */
    String getMessageFromBuffer();

    /**
     * Clear buffer.
     */
    void clearBuffer();

    /**
     * Sets message.
     *
     * @param messageToAddToBuffer the message to add to buffer
     */
    void setMessage(String messageToAddToBuffer);
}
