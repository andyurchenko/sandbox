package it.sevenbits.directory.analyzer.file.tools.indent;

/**
 * The type Indent.
 */
public class Indent implements IIndent {
    private int indentCurrentCount;
    private final int INDENT_STANDART_SIZE_IN_BLANKS = 3;
    private final String INDENT_STANDART = " ";
    private final StringBuilder stringBuilder;

    /**
     * Instantiates a new Indent.
     */
    public Indent() {
        this.indentCurrentCount = 0;
        this.stringBuilder = new StringBuilder();
    }
    /**
     * Get an indent.
     * @param sizeOfIndent Size of indent
     * @return Indent as a string
     */
    public String getIndent(final int sizeOfIndent) {
        changeIntend(checkNewIntend(sizeOfIndent));
        return this.stringBuilder.toString();
    }

    private int checkNewIntend(final int indentToCheck) {
        return Math.max(indentToCheck, 0);
    }

    private void changeIntend(final int indentNewCount) {
        if (this.indentCurrentCount < indentNewCount) {
            addToIndent(indentNewCount - this.indentCurrentCount);
        } else if (this.indentCurrentCount > indentNewCount) {
            deleteFromIndent(this.indentCurrentCount - indentNewCount);
        }
    }

    private void deleteFromIndent(final int indentCountToDelete) {
        int currentIndex = (this.indentCurrentCount * INDENT_STANDART_SIZE_IN_BLANKS) - 1;
        int deleteFromIndex = (currentIndex + 1) - (indentCountToDelete * INDENT_STANDART_SIZE_IN_BLANKS);
        this.stringBuilder.delete(deleteFromIndex, currentIndex + 1);
        this.indentCurrentCount -= indentCountToDelete;
        if (this.indentCurrentCount < 0) {
            this.indentCurrentCount = 0;
        }
    }

    private void addToIndent(final int indentCountToAdd) {
        for (int i = 0; i < indentCountToAdd * INDENT_STANDART_SIZE_IN_BLANKS; i++) {
            this.stringBuilder.append(INDENT_STANDART);
        }
        this.indentCurrentCount += indentCountToAdd;
    }
}
