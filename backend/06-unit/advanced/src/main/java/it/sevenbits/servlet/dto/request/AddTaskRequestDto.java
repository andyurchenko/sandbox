package it.sevenbits.servlet.dto.request;

/**
 * The type Add task request dto.
 */
public class AddTaskRequestDto {
    private String text;

    /**
     * Instantiates a new Add task request dto.
     */
    public AddTaskRequestDto() {
    }

    /**
     * Instantiates a new Add task request dto.
     *
     * @param text the text
     */
    public AddTaskRequestDto(final String text) {
        this.text = text;
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
}
