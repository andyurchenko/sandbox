package it.sevenbits.formatter;

import it.sevenbits.formatter.fsm.FormatterState;
import it.sevenbits.lexer.token.IToken;


/**
 * The interface Formatter data access.
 */
public interface IFormatterDataAccess {
    /**
     * Gets current token.
     *
     * @return the current token
     */
    IToken getCurrentToken();

    /**
     * Gets current state.
     *
     * @return the current state
     */
    FormatterState getCurrentState();

    /**
     * Gets next state.
     *
     * @return the next state
     */
    FormatterState getNextState();

    /**
     * Read next token.
     */
    void readNextToken();

    /**
     * Write string to.
     *
     * @param str the str
     */
    void writeStringTo(String str);

    /**
     * Increase indent.
     */
    void increaseIndent();

    /**
     * Decrease indent.
     */
    void decreaseIndent();

    /**
     * Add to buffer.
     *
     * @param str the str
     */
    void addToBuffer(String str);

    /**
     * Write buffer.
     */
    void writeBuffer();

    /**
     * Gets indent.
     *
     * @return the indent
     */
    IIndent getIndent();

    /**
     * Gets current indent size.
     *
     * @return the current indent size
     */
    int getCurrentIndentSize();

    /**
     * Delete standard indent size from buffer.
     */
    void deleteStandardIndentSizeFromBuffer();

    /**
     * Delete current indent size from buffer.
     */
    void deleteCurrentIndentSizeFromBuffer();

    /**
     * Delete new line from buffer.
     */
    void deleteNewLineFromBuffer();

    /**
     * Sets mark to the next position to add.
     */
    void setMarkToTheNextPositionToAdd();

    /**
     * Delete indent and new line before the mark.
     */
    void deleteIndentAndNewLineBeforeTheMark();

    /**
     * Delete indent before the mark.
     */
    void deleteIndentBeforeTheMark();

    /**
     * Delete all chars from current position to mark position.
     */
    void deleteAllCharsFromCurrentPositionToMarkPosition();
}
