package it.sevenbits.formatter.fsm;

import java.util.Objects;

/**
 * The type Formatter event.
 */
public class FormatterEvent {
    private String eventName;

    /**
     * Instantiates a new Formatter event.
     *
     * @param eventName the event name
     */
    public FormatterEvent(final String eventName) {
        this.eventName = eventName;
    }

    /**
     * Instantiates a new Formatter event.
     */
    public FormatterEvent() {
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
        FormatterEvent formatterEvent = (FormatterEvent) o;
        return Objects.equals(eventName, formatterEvent.eventName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventName);
    }
}
