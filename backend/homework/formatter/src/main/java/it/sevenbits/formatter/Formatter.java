package it.sevenbits.formatter;

import it.sevenbits.formatter.command.ICommand;
import it.sevenbits.formatter.command.factory.IFormatterCommandFactory;
import it.sevenbits.formatter.fsm.FormatterEvent;
import it.sevenbits.formatter.fsm.factory.IFormatterStateFactory;
import it.sevenbits.formatter.fsm.FormatterState;
import it.sevenbits.lexer.ILexer;
import it.sevenbits.lexer.token.IToken;
import it.sevenbits.tool.buffer.SmartBuffer;
import it.sevenbits.tool.writer.IWriter;

/**
 * The type Formatter.
 */
public class Formatter implements IFormatterDataAccess {
    private final ILexer lexer;
    private FormatterState currentFormatterState;
    private FormatterState nextFormatterState;
    private final SmartBuffer buffer;
    private final IWriter writer;
    private final IFormatterCommandFactory commandFactory;
    private final IFormatterStateFactory stateFactory;
    private IToken currentToken;
    private final IIndent indent;

    /**
     * Instantiates a new Formatter.
     *
     * @param lexer              the lexer
     * @param writer             the writer
     * @param stateFactory       the state factory
     * @param commandFactory     the command factory
     * @param indentStandardSize the indent standard size
     */
    public Formatter(final ILexer lexer, final IWriter writer, final IFormatterStateFactory stateFactory, final IFormatterCommandFactory commandFactory, final int indentStandardSize) {
        this.buffer = new SmartBuffer();
        this.lexer = lexer;
        this.writer = writer;
        this.stateFactory = stateFactory;
        this.currentFormatterState = this.stateFactory.getStartState();
        this.commandFactory = commandFactory;
        this.commandFactory.setFormatter(this);
        this.indent = new Indent(indentStandardSize);
    }

    public IIndent getIndent() {
        return indent;
    }

    @Override
    public int getCurrentIndentSize() {
        return this.indent.getCurrentIndentSize();
    }

    @Override
    public void deleteStandardIndentSizeFromBuffer() {
        this.buffer.deleteLastNCharsFromBuffer(this.getIndentStandardSize());
    }

    private int getIndentStandardSize() {
        return this.getIndent().getIndentStandardSize();
    }

    @Override
    public void deleteCurrentIndentSizeFromBuffer() {
        this.buffer.deleteLastNCharsFromBuffer(this.getCurrentIndentSize());
    }

    @Override
    public void deleteNewLineFromBuffer() {
        this.buffer.deleteLastNCharsFromBuffer(1);
    }

    @Override
    public void setMarkToTheNextPositionToAdd() {
        this.buffer.setMarkToTheNextPositionToAdd();
    }

    @Override
    public void deleteIndentAndNewLineBeforeTheMark() {
        int currentIndentSizePlusNewLineChar = this.getCurrentIndentSize() + 1;
        this.buffer.deleteCharactersFromTheMarkToTheLeft(currentIndentSizePlusNewLineChar);
    }

    @Override
    public void deleteIndentBeforeTheMark() {
        this.buffer.deleteCharactersFromTheMarkToTheLeft(this.getCurrentIndentSize());
    }

    @Override
    public void deleteAllCharsFromCurrentPositionToMarkPosition() {
        this.buffer.deleteAllCharsFromCurrentPositionToMarkPosition();
    }

    /**
     * Format and write to file.
     */
    public void formatAndWriteToFile() {
        ICommand command;
        readNextTokenIfAvailable();
        while (this.getCurrentToken() != null) {
            this.nextFormatterState = this.stateFactory.getNextState(this.getCurrentState(), new FormatterEvent(this.getCurrentToken().getLexemeType()));
            command = this.commandFactory.getCommand();
            if (command != null) {
                command.execute();
            }
            this.currentFormatterState = this.nextFormatterState;
        }
        this.writeBuffer();
        writer.closeWriter();
    }

    private void readNextTokenIfAvailable() {
        if (lexer.hasMoreTokens()) {
            this.readNextToken();
        }
    }

    /**
     * Read next token in line.
     */
    public void readNextToken() {
        currentToken = lexer.getNextToken();
    }

    public IToken getCurrentToken() {
        return currentToken;
    }

    public FormatterState getCurrentState() {
        return currentFormatterState;
    }

    public FormatterState getNextState() {
        return nextFormatterState;
    }

    @Override
    public void writeStringTo(final String str) {
        writer.write(str);
    }

    @Override
    public void increaseIndent() {
        this.indent.increaseIndentSize();
    }

    @Override
    public void decreaseIndent() {
        this.indent.decreaseIndentSize();
    }

    @Override
    public void addToBuffer(final String str) {
        this.buffer.addToBuffer(str);
    }

    @Override
    public void writeBuffer() {
        this.writer.write(this.buffer.getBuffer());
        this.buffer.clearBuffer();
    }


}
