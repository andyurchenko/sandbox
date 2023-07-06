package it.sevenbits.servlet.model;

/**
 * The type Task.
 */
public class Task {
    private String id;
    private String text;
    private String status;

    /**
     * Instantiates a new Task.
     *
     * @param text the text
     */
    public Task(final String text) {
        this.text = text;
        this.status = TaskStatus.INBOX.getStatus();
    }

    /**
     * Instantiates a new Task.
     *
     * @param id     the id
     * @param text   the text
     * @param status the status
     */
    public Task(final String id, final String text, final String status) {
        this.id = id;
        this.text = text;
        this.status = status;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * Gets text.
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets text.
     *
     * @param text the text
     */
    public void setText(final String text) {
        this.text = text;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(final String status) {
        this.status = status;
    }
}
