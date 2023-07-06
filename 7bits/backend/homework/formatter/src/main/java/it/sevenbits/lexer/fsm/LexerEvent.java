package it.sevenbits.lexer.fsm;

import java.util.Objects;

/**
 * The type Lexer event.
 */
public class LexerEvent {
    private String eventName;

    /**
     * Instantiates a new Lexer event.
     *
     * @param eventName the event name
     */
    public LexerEvent(final String eventName) {
        this.eventName = eventName;
    }

    /**
     * Instantiates a new Lexer event.
     */
    public LexerEvent() {
    }

    /**
     * Gets event name.
     *
     * @return the event name
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * Sets event name.
     *
     * @param eventName the event name
     */
    public void setEventName(final String eventName) {
        this.eventName = eventName;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LexerEvent lexerEvent = (LexerEvent) o;
        return Objects.equals(eventName, lexerEvent.eventName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventName);
    }
}
