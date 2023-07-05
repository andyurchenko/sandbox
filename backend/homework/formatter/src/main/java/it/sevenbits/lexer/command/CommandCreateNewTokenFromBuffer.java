package it.sevenbits.lexer.command;

import it.sevenbits.lexer.ILexerDataAccess;

/**
 * The type Command create new token from buffer.
 */
public class CommandCreateNewTokenFromBuffer implements ICommand {
    private final ILexerDataAccess lexer;

    /**
     * Instantiates a new Command create new token from buffer.
     *
     * @param lexer the lexer
     */
    public CommandCreateNewTokenFromBuffer(final ILexerDataAccess lexer) {
        this.lexer = lexer;
    }

    @Override
    public void execute() {
        this.lexer.createNewTokenFromBuffer();
    }
}
