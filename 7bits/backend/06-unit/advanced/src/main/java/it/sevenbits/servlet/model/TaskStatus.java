package it.sevenbits.servlet.model;

/**
 * The enum Task status.
 */
public enum TaskStatus {
    /**
     * Done task status.
     */
    DONE("done"),
    /**
     * Inbox task status.
     */
    INBOX("inbox"),

    ;

    private String status;

    /**
     *
     * @param status status
     */
    TaskStatus(final String status) {
        this.status = status;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }
}
