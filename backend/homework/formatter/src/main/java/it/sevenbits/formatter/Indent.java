package it.sevenbits.formatter;

/**
 * The type Indent.
 */
public class Indent implements IIndent {
    private final StringBuilder indent;
    private final StringBuilder indentStandard;
    private final int indentSize;

    /**
     * Instantiates a new Indent.
     *
     * @param indentSize the indent size
     */
    public Indent(final int indentSize) {
        indent = new StringBuilder();
        indentStandard = new StringBuilder();
        this.indentSize = indentSize;
        for (int i = 0; i < indentSize; i++) {
            indentStandard.append(" ");
        }
    }

    /**
     * Just increase indent.
     */
    public void increaseIndentSize() {
        this.indent.append(indentStandard.toString());
    }

    /**
     * Just decrease indent.
     */
    public void decreaseIndentSize() {
        int newLength = this.indent.length() - this.indentSize;
        if (newLength < 0) {
            newLength = 0;
        }
        this.indent.setLength(newLength);
    }

    public String getIndent() {
        return this.indent.toString();
    }

    @Override
    public int getIndentStandardSize() {
        return this.indentSize;
    }

    @Override
    public int getCurrentIndentSize() {
        return this.indent.length();
    }

}
