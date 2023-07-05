package it.sevenbits.lexer.command.factory;

import it.sevenbits.lexer.command.CommandAddToBuffer;
import it.sevenbits.lexer.command.CommandClearBuffer;
import it.sevenbits.lexer.command.CommandCreateNewTokenFromBuffer;
import it.sevenbits.lexer.command.CommandCreateTokenFromCurrentCharacter;
import it.sevenbits.lexer.command.CommandReadNextCharacter;
import it.sevenbits.lexer.command.ICommand;
import it.sevenbits.lexer.command.IMacroCommand;
import it.sevenbits.lexer.command.MacroCommand;
import it.sevenbits.lexer.fsm.LexerStatesPair;
import it.sevenbits.lexer.ILexerDataAccess;
import it.sevenbits.lexer.fsm.LexerState;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Lexer command factory.
 */
public class LexerCommandFactory implements ILexerCommandFactory {
    private ILexerDataAccess lexerDataAccess;

    private final Map<LexerStatesPair, ICommand> commands;

    private ICommand commandAddToBuffer;
    private ICommand commandCreateNewTokenFromBuffer;
    private ICommand commandCreateNewTokenFromCurrentCharacter;
    private ICommand commandClearBuffer;
    private ICommand commandReadNextCharacter;


    private IMacroCommand createFromBufferClearBuffer;
    private IMacroCommand createFromBufferClearBufferAddToBuffer;
    private IMacroCommand addToBufferCreateFromBufferClearBuffer;
    private IMacroCommand addToBufferReadNextCharacter;
    private IMacroCommand createFromCurrentCharacterReadNextCharacter;

    /**
     * Instantiates a new Lexer command factory.
     */
    public LexerCommandFactory() {

        this.commands = new HashMap<>();
    }

    private void fillUpActionTable() {
        //START
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("START")), (ICommand) createFromCurrentCharacterReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("WORD")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("NUMBER")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("STRING")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("CHAR")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("SPACE")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("NEW_LINE")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("`")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("~")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("!")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("@")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("#")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("$")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("%")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("^")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("&")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("*")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("(")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState(")")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("-")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("=")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("+")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("[")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("]")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("{")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("}")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("\\")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("|")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState(";")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState(":")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState(",")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("<")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState(".")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState(">")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("/")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("?")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("START"), new LexerState("UNLISTED_CHARACTER")), (ICommand) addToBufferReadNextCharacter);

        //WORD
        this.commands.put(new LexerStatesPair(new LexerState("WORD"), new LexerState("WORD")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("WORD"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);

        //NUMBER
        this.commands.put(new LexerStatesPair(new LexerState("NUMBER"), new LexerState("NUMBER")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("NUMBER"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);

        //SPECIAL CHARACTERS
        this.commands.put(new LexerStatesPair(new LexerState("`"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("~"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("!"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("@"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("#"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("$"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("%"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("^"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("&"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("("), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState(")"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("-"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("="), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("+"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("["), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("]"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("{"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("}"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("|"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState(";"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState(":"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState(","), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("<"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("."), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState(">"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("?"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);

        this.commands.put(new LexerStatesPair(new LexerState("/"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("/"), new LexerState("COMMENT_ONE_LINE_START")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("/"), new LexerState("COMMENT_MANY_LINES_START")), (ICommand) addToBufferReadNextCharacter);

        this.commands.put(new LexerStatesPair(new LexerState("*"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("*"), new LexerState("COMMENT_MANY_LINES_END")), (ICommand) addToBufferReadNextCharacter);

        this.commands.put(new LexerStatesPair(new LexerState("\\"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("\\"), new LexerState("STRING_ESCAPE_CHARACTER")), (ICommand) addToBufferReadNextCharacter);
        this.commands.put(new LexerStatesPair(new LexerState("\\"), new LexerState("CHAR_ESCAPE_CHARACTER")), (ICommand) addToBufferReadNextCharacter);

        this.commands.put(new LexerStatesPair(new LexerState("STRING"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("CHAR"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("SPACE"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("NEW_LINE"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("STRING_ESCAPE_CHARACTER"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("CHAR_ESCAPE_CHARACTER"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("COMMENT_ONE_LINE_START"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("COMMENT_MANY_LINES_START"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
        this.commands.put(new LexerStatesPair(new LexerState("COMMENT_MANY_LINES_END"), new LexerState("START")), (ICommand) createFromBufferClearBuffer);
    }

    @Override
    public ICommand getCommand() {
        return this.commands.getOrDefault(
                new LexerStatesPair(this.lexerDataAccess.getCurrentState(), this.lexerDataAccess.getNextState()), (ICommand) createFromBufferClearBufferAddToBuffer);
    }

    @Override
    public void setLexer(final ILexerDataAccess inLexerDataAccess) {
        this.lexerDataAccess = inLexerDataAccess;
        this.commandAddToBuffer = new CommandAddToBuffer(inLexerDataAccess);
        this.commandCreateNewTokenFromBuffer = new CommandCreateNewTokenFromBuffer(inLexerDataAccess);
        this.commandClearBuffer = new CommandClearBuffer(inLexerDataAccess);
        this.commandReadNextCharacter = new CommandReadNextCharacter(inLexerDataAccess);
        this.commandCreateNewTokenFromCurrentCharacter = new CommandCreateTokenFromCurrentCharacter(inLexerDataAccess);

        this.createFromBufferClearBuffer = new MacroCommand();
        this.createFromBufferClearBufferAddToBuffer = new MacroCommand();
        this.addToBufferCreateFromBufferClearBuffer = new MacroCommand();
        this.addToBufferReadNextCharacter = new MacroCommand();
        this.createFromCurrentCharacterReadNextCharacter = new MacroCommand();

        createFromBufferClearBuffer.addNewCommand(commandCreateNewTokenFromBuffer);
        createFromBufferClearBuffer.addNewCommand(commandClearBuffer);

        createFromBufferClearBufferAddToBuffer.addNewCommand(commandCreateNewTokenFromBuffer);
        createFromBufferClearBufferAddToBuffer.addNewCommand(commandClearBuffer);
        createFromBufferClearBufferAddToBuffer.addNewCommand(commandAddToBuffer);

        addToBufferReadNextCharacter.addNewCommand(commandAddToBuffer);
        addToBufferReadNextCharacter.addNewCommand(commandReadNextCharacter);

        createFromCurrentCharacterReadNextCharacter.addNewCommand(commandCreateNewTokenFromCurrentCharacter);
        createFromCurrentCharacterReadNextCharacter.addNewCommand(commandReadNextCharacter);

        fillUpActionTable();
    }
}
