package it.sevenbits.tool.buffer;

/**
 * The type Smart buffer.
 */
public class SmartBuffer {
    private final StringBuilder stringBuilder;
    private int mark;
    private final char NULL = '\u0000';

    /**
     * Instantiates a new Smart buffer.
     */
    public SmartBuffer() {
        this.stringBuilder = new StringBuilder();
        this.mark = 0;
    }

    /**
     * Gets buffer.
     *
     * @return the buffer
     */
    public String getBuffer() {
        return stringBuilder.toString();
    }

    /**
     * Add to buffer.
     *
     * @param str the str
     */
    public void addToBuffer(final String str) {
        this.stringBuilder.append(str);
    }

    /**
     * Add to buffer with marking position of first char of added string.
     *
     * @param str the str
     */
    public void addToBufferWithMarkingPositionOfFirstCharOfAddedString(final String str) {
        this.mark = this.stringBuilder.length();
        this.stringBuilder.append(str);
    }

    /**
     * Delete all chars from current position to mark position.
     */
    public void deleteAllCharsFromCurrentPositionToMarkPosition() {
        for (int i = this.stringBuilder.length() - 1; i >= this.mark; i--) {
            this.stringBuilder.setCharAt(i, NULL);
        }
        this.stringBuilder.setLength(this.mark);
    }

    /**
     * Clear buffer.
     */
    public void clearBuffer() {
        for (int i = 0; i < this.stringBuilder.length(); i++) {
            this.stringBuilder.setCharAt(i, NULL);
        }
        this.stringBuilder.setLength(0);
    }

    /**
     * Gets current position.
     *
     * @return the current position
     */
    public int getCurrentPosition() {
        return this.stringBuilder.length() - 1;
    }

    /**
     * Sets mark to the next position to add.
     */
    public void setMarkToTheNextPositionToAdd() {
        this.mark = this.stringBuilder.length();
    }

    /**
     * Sets mark to given position.
     *
     * @param pointerPosition the pointer position
     */
    public void setMarkToGivenPosition(int pointerPosition) {
        if (pointerPosition < 0) {
            pointerPosition = 0;
        }
        this.mark = pointerPosition;
    }

    /**
     * Gets mark position.
     *
     * @return the mark position
     */
    public int getMarkPosition() {
        return this.mark;
    }

    /**
     * Delete characters from the mark to the right.
     *
     * @param numberOfCharactersToDelete the number of characters to delete
     */
    public void deleteCharactersFromTheMarkToTheRight(int numberOfCharactersToDelete) {
        int numberOfAvailableCharsToDeleteOnTheRightSide = this.stringBuilder.length() - this.getMarkPosition();
        if (numberOfCharactersToDelete > numberOfAvailableCharsToDeleteOnTheRightSide) {
            numberOfCharactersToDelete = numberOfAvailableCharsToDeleteOnTheRightSide;
        }
        this.stringBuilder.delete(this.getMarkPosition(), this.getMarkPosition() + numberOfCharactersToDelete);
    }

    /**
     * Delete characters from the mark to the left.
     *
     * @param numberOfCharactersToDelete the number of characters to delete
     */
    @SuppressWarnings("checkstyle:FinalParameters")
    public void deleteCharactersFromTheMarkToTheLeft(int numberOfCharactersToDelete) {
        int numberOfAvailableCharsToDeleteOnTheLeftSide = this.getMarkPosition();
        if (numberOfCharactersToDelete > numberOfAvailableCharsToDeleteOnTheLeftSide) {
            numberOfCharactersToDelete = numberOfAvailableCharsToDeleteOnTheLeftSide;
        }
        int startPositionToDeleteInclusively = this.getMarkPosition() - numberOfCharactersToDelete;
        int endPositionToDeleteExclusively = this.getMarkPosition();
        this.stringBuilder.delete(startPositionToDeleteInclusively, endPositionToDeleteExclusively);
        this.setMarkToGivenPosition(startPositionToDeleteInclusively);
    }

    /**
     * Delete last n chars from buffer.
     *
     * @param numberOfCharsToDelete the number of chars to delete
     */
    public void deleteLastNCharsFromBuffer(int numberOfCharsToDelete) {
        if (numberOfCharsToDelete > this.stringBuilder.length()) {
            numberOfCharsToDelete = this.stringBuilder.length();
        }
        this.stringBuilder.setLength(this.stringBuilder.length() - numberOfCharsToDelete);
    }
}
