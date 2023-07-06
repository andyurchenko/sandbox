package it.sevenbits.lexer.token;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Token pool array.
 */
public class TokenPoolArray implements ITokenPool {

    private final List<IToken> tokens;
    private int currentTokenIndex;

    /**
     * Instantiates a new Token pool array.
     */
    public TokenPoolArray() {
        this.tokens = new ArrayList<>();
        this.currentTokenIndex = 0;
    }

    @Override
    public boolean hasMoreTokens() {
        return this.currentTokenIndex < tokens.size();
    }

    @Override
    public IToken getNextToken() {
        if (hasMoreTokens()) {
            return this.tokens.get(this.currentTokenIndex++);
        } else {
            return null;
        }
    }

    @Override
    public void addNewToken(final IToken tokenToAdd) {
        this.tokens.add(tokenToAdd);

    }
}
