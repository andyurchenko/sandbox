package it.sevenbits.lexer.command;

import it.sevenbits.lexer.ILexerDataAccess;

/**
 * The type Command create token from current character.
 */
public class CommandCreateTokenFromCurrentCharacter implements ICommand {
    private final ILexerDataAccess lexer;

    /**
     * Instantiates a new Command create token from current character.
     *
     * @param lexer the lexer
     */
    public CommandCreateTokenFromCurrentCharacter(final ILexerDataAccess lexer) {
        this.lexer = lexer;
    }

    @Override
    public void execute() {
        this.lexer.createNewTokenFromCurrentCharacter();
    }
}
