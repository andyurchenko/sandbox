package it.sevenbits.lexer.command;

import it.sevenbits.lexer.ILexerDataAccess;

/**
 * The type Command read next character.
 */
public class CommandReadNextCharacter implements ICommand {
    private ILexerDataAccess lexer;

    /**
     * Instantiates a new Command read next character.
     *
     * @param lexer the lexer
     */
    public CommandReadNextCharacter(final ILexerDataAccess lexer) {
        this.lexer = lexer;
    }

    @Override
    public void execute() {
        this.lexer.readNextCharacter();
    }
}
