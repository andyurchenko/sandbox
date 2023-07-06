package it.sevenbits.lexer;

import it.sevenbits.lexer.command.ICommand;
import it.sevenbits.lexer.command.factory.ILexerCommandFactory;
import it.sevenbits.lexer.fsm.factory.ILexerStateFactory;
import it.sevenbits.lexer.fsm.LexerState;
import it.sevenbits.lexer.token.IToken;
import it.sevenbits.lexer.token.ITokenPool;
import it.sevenbits.lexer.token.ITokenType;
import it.sevenbits.lexer.token.Token;
import it.sevenbits.lexer.token.TokenPoolArray;
import it.sevenbits.tool.reader.IReader;

/**
 * The type Lexer.
 */
public class Lexer implements ILexer, ILexerDataAccess {
    private LexerState currentLexerState;
    private LexerState nextLexerState;

    private String currentCharacter;
    private final StringBuilder charsBuffer;
    private final ITokenPool tokenPool;
    private final IReader reader;
    private final ILexerCommandFactory commandFactory;
    private final ILexerStateFactory stateFactory;
    private final ITokenType tokenType;
    private final String unsuportedChar = "UNSUPPORTED_CHARACTER";

    /**
     * Instantiates a new Lexer.
     *
     * @param reader         the reader
     * @param commandFactory the command factory
     * @param stateFactory   the state factory
     * @param tokenType      the token type
     */
    public Lexer(final IReader reader, final ILexerCommandFactory commandFactory, final ILexerStateFactory stateFactory, final ITokenType tokenType) {
        this.reader = reader;
        this.charsBuffer = new StringBuilder();
        this.commandFactory = commandFactory;
        this.commandFactory.setLexer(this);
        this.stateFactory = stateFactory;
        this.currentLexerState = stateFactory.getStartState();
        this.nextLexerState = null;
        this.tokenPool = new TokenPoolArray();
        this.tokenType = tokenType;

        this.analyzeRawTextAndCreateTokens();
    }

    private void analyzeRawTextAndCreateTokens() {
        ICommand command;
        readNextCharacterIfAvailable();
        while (reader.hasNext()) {
            this.nextLexerState = this.stateFactory.getNextState(this.getCurrentState(), this.getCurrentCharacter());
            command = this.commandFactory.getCommand();
            command.execute();
            this.currentLexerState = this.nextLexerState;
        }

        if (this.charsBuffer.length() > 0) {
           this.createNewTokenFromBuffer();
           this.clearBuffer();
        }
    }

    private void readNextCharacterIfAvailable() {
        if (reader.hasNext()) {
            this.readNextCharacter();
        }
    }

    @Override
    public boolean hasMoreTokens() {
        return this.tokenPool.hasMoreTokens();
    }

    @Override
    public IToken getNextToken() {
        return this.tokenPool.getNextToken();
    }

    public String getCurrentCharacter() {
        return this.currentCharacter;
    }

    @Override
    public void addToCurrentCharBuffer() {
        this.charsBuffer.append(this.getCurrentCharacter());
    }

    @Override
    public LexerState getCurrentState() {
        return this.currentLexerState;
    }

    @Override
    public LexerState getNextState() {
        return this.nextLexerState;
    }

    /**
     * Gets chars buffer.
     *
     * @return the chars buffer
     */
    public StringBuilder getCharsBuffer() {
        return charsBuffer;
    }

    private void addNewTokenToTokenPool(final IToken tokenToAdd) {
        this.tokenPool.addNewToken(tokenToAdd);
    }

    @Override
    public void clearBuffer() {
        this.charsBuffer.delete(0, this.charsBuffer.length());
        this.charsBuffer.setLength(0);
    }

    @Override
    public void readNextCharacter() {
        this.currentCharacter = String.valueOf(this.reader.readNextCharacter());
    }

    @Override
    public void createNewTokenFromBuffer() {
        if (charsBuffer.length() != 0) {
            this.addNewTokenToTokenPool(new Token(getTokenType(), charsBuffer.toString()));
            charsBuffer.setLength(0);
        }
    }

    @Override
    public void createNewTokenFromCurrentCharacter() {
        this.addNewTokenToTokenPool(new Token(getTokenType(), this.getCurrentCharacter()));
    }

    private String getTokenType() {
        String tokenType;
        if (this.getCurrentState() == this.stateFactory.getStartState()) {
            tokenType = unsuportedChar;
        } else {
            tokenType = this.getCurrentState().getStateName();
        }
        return this.tokenType.getTokenType(tokenType, this.charsBuffer.toString());
    }
}
