package it.sevenbits.servlet.dto.request;

/**
 * The type Update task status request dto.
 */
public class UpdateTaskStatusRequestDto {
    private String status;

    /**
     * Instantiates a new Update task status request dto.
     */
    public UpdateTaskStatusRequestDto() {
    }

    /**
     * Instantiates a new Update task status request dto.
     *
     * @param status the status
     */
    public UpdateTaskStatusRequestDto(final String status) {
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

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(final String status) {
        this.status = status;
    }
}
