package it.sevenbits.courses.sm.manager.messages;

/**
 * The type Message manager.
 */
public class MessageManager implements IMessageManager {
    private StringBuilder sb;
    private String messageToAddToBuffer;

    /**
     * Instantiates a new Message manager.
     */
    public MessageManager() {
        this.sb = new StringBuilder();
    }
    @Override
    public void addMessageToBuffer() {
        sb.append(messageToAddToBuffer);
    }

    @Override
    public String getMessageFromBuffer() {
        return this.sb.toString();
    }

    @Override
    public void clearBuffer() {
        sb.setLength(0);
    }

    @Override
    public void setMessage(final String messageToAddToBuffer) {
        this.messageToAddToBuffer = messageToAddToBuffer;
    }
}
