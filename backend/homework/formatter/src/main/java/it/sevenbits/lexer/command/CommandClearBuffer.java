package it.sevenbits.lexer.command;

import it.sevenbits.lexer.ILexerDataAccess;

/**
 * The type Command clear buffer.
 */
public class CommandClearBuffer implements ICommand {
    private ILexerDataAccess lexer;

    /**
     * Instantiates a new Command clear buffer.
     *
     * @param lexer the lexer
     */
    public CommandClearBuffer(final ILexerDataAccess lexer) {
        this.lexer = lexer;
    }

    @Override
    public void execute() {
        this.lexer.clearBuffer();
    }
}
