package it.sevenbits.lexer.command;

import it.sevenbits.lexer.ILexerDataAccess;

/**
 * The type Command add to buffer.
 */
public class CommandAddToBuffer implements ICommand {

    private ILexerDataAccess lexer;

    /**
     * Instantiates a new Command add to buffer.
     *
     * @param lexer the lexer
     */
    public CommandAddToBuffer(final ILexerDataAccess lexer) {
        this.lexer = lexer;
    }

    @Override
    public void execute() {
        this.lexer.addToCurrentCharBuffer();
    }
}
