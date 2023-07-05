package it.sevenbits.formatter.command.factory;

import it.sevenbits.formatter.IFormatterDataAccess;
import it.sevenbits.formatter.command.CommandAddIndentToBuffer;
import it.sevenbits.formatter.command.CommandAddNewLineToBuffer;
import it.sevenbits.formatter.command.CommandAddSpaceToBuffer;
import it.sevenbits.formatter.command.CommandAddTokenToBuffer;
import it.sevenbits.formatter.command.CommandDecreaseIndent;
import it.sevenbits.formatter.command.CommandDeleteAllCharsFromCurrentPositionToMarkPosition;
import it.sevenbits.formatter.command.CommandDeleteCurrentIndentSizeFromBuffer;
import it.sevenbits.formatter.command.CommandDeleteIndentAndNewLineBeforeTheMark;
import it.sevenbits.formatter.command.CommandDeleteIndentBeforeTheMark;
import it.sevenbits.formatter.command.CommandDeleteNewLineFromBuffer;
import it.sevenbits.formatter.command.CommandDeleteStandardIndentSizeFromBuffer;
import it.sevenbits.formatter.command.CommandFormatterDefault;
import it.sevenbits.formatter.command.CommandIncreaseIndent;
import it.sevenbits.formatter.command.CommandReadNextToken;
import it.sevenbits.formatter.command.CommandSetMarkToTheNextPositionToAdd;
import it.sevenbits.formatter.command.CommandWriteBuffer;
import it.sevenbits.formatter.command.ICommand;
import it.sevenbits.formatter.command.IMacroCommand;
import it.sevenbits.formatter.command.MacroCommand;
import it.sevenbits.formatter.fsm.FormatterState;
import it.sevenbits.formatter.fsm.FormatterStatesPair;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Formatter command factory.
 */
public class FormatterCommandFactory implements IFormatterCommandFactory {

    private Map<FormatterStatesPair, ICommand> commands;
    private CommandDecreaseIndent commandDecreaseIndent;
    private CommandIncreaseIndent commandIncreaseIndent;
    private CommandReadNextToken commandReadNextToken;
    private CommandFormatterDefault commandFormatterDefault;
    private CommandAddSpaceToBuffer commandAddSpaceToBuffer;

    private CommandAddTokenToBuffer commandAddTokenToBuffer;
    private CommandAddNewLineToBuffer commandAddNewLineToBuffer;
    private CommandAddIndentToBuffer commandAddIndentToBuffer;
    private CommandWriteBuffer commandWriteBuffer;
    private CommandDeleteIndentAndNewLineBeforeTheMark commandDeleteIndentAndNewLineBeforeTheMark;
    private CommandDeleteIndentBeforeTheMark commandDeleteIndentBeforeTheMark;
    private CommandSetMarkToTheNextPositionToAdd commandSetMarkToTheNextPositionToAdd;

    private CommandDeleteStandardIndentSizeFromBuffer commandDeleteStandardIndentSizeFromBuffer;
    private CommandDeleteCurrentIndentSizeFromBuffer commandDeleteCurrentIndentSizeFromBuffer;
    private CommandDeleteNewLineFromBuffer commandDeleteNewLineFromBuffer;
    private CommandDeleteAllCharsFromCurrentPositionToMarkPosition commandDeleteAllCharsFromCurrentPositionToMarkPosition;

    private IFormatterDataAccess formatter;


    /**
     * Instantiates a new Formatter command factory.
     */
    public FormatterCommandFactory() {
        this.commands = new HashMap<>();
    }

    @SuppressWarnings("checkstyle:MethodLength")
    private void fillUpActionTable() {
        IMacroCommand macroCommand;
        commandDecreaseIndent = new CommandDecreaseIndent(formatter);
        commandIncreaseIndent = new CommandIncreaseIndent(formatter);
        commandReadNextToken = new CommandReadNextToken(formatter);
        commandFormatterDefault = new CommandFormatterDefault(formatter);
        commandAddTokenToBuffer = new CommandAddTokenToBuffer(formatter);
        commandWriteBuffer = new CommandWriteBuffer(formatter);
        commandDeleteStandardIndentSizeFromBuffer = new CommandDeleteStandardIndentSizeFromBuffer(formatter);
        commandDeleteNewLineFromBuffer = new CommandDeleteNewLineFromBuffer(formatter);
        commandAddNewLineToBuffer = new CommandAddNewLineToBuffer(formatter);
        commandAddIndentToBuffer = new CommandAddIndentToBuffer(formatter);
        commandAddSpaceToBuffer = new CommandAddSpaceToBuffer(formatter);
        commandSetMarkToTheNextPositionToAdd = new CommandSetMarkToTheNextPositionToAdd(formatter);
        commandDeleteIndentAndNewLineBeforeTheMark = new CommandDeleteIndentAndNewLineBeforeTheMark(formatter);
        commandDeleteAllCharsFromCurrentPositionToMarkPosition = new CommandDeleteAllCharsFromCurrentPositionToMarkPosition(formatter);
        commandDeleteCurrentIndentSizeFromBuffer = new CommandDeleteCurrentIndentSizeFromBuffer(formatter);
        commandDeleteIndentBeforeTheMark = new CommandDeleteIndentBeforeTheMark(formatter);

//START  --->  WORD
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("WORD")), (ICommand) macroCommand);

//START  --->  NUMBER
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("NUMBER")), (ICommand) macroCommand);

//START  --->  SPACE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("SPACE")), (ICommand) macroCommand);

//SPACE  --->  SPACE
        this.commands.put(new FormatterStatesPair(new FormatterState("SPACE"), new FormatterState("SPACE")), commandReadNextToken);

//START  --->  NEW_LINE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandAddIndentToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("NEW_LINE")), (ICommand) macroCommand);

//NEW_LINE  --->  IGNORE_SPACES
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("NEW_LINE"), new FormatterState("IGNORE_SPACES")), (ICommand) macroCommand);

//START  --->  !
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("!")), (ICommand) macroCommand);

//START  --->  @
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("@")), (ICommand) macroCommand);

//START  --->  #
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("#")), (ICommand) macroCommand);

//START  --->  $
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("$")), (ICommand) macroCommand);

        //START --> %
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("%")), (ICommand) macroCommand);

        //START --> ^
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("^")), (ICommand) macroCommand);

        //START --> &
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("&")), (ICommand) macroCommand);

        //START --> *
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("*")), (ICommand) macroCommand);

        //START --> (
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("(")), (ICommand) macroCommand);

        //START --> )
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState(")")), (ICommand) macroCommand);

        //START --> -
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("-")), (ICommand) macroCommand);

        //START --> =
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("=")), (ICommand) macroCommand);

        //START --> +
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("+")), (ICommand) macroCommand);

        //START --> |
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("|")), (ICommand) macroCommand);

        //START --> \
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("\\")), (ICommand) macroCommand);

        //START --> \
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("\\")), (ICommand) macroCommand);

        //START --> ?
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("?")), (ICommand) macroCommand);

        //START --> .
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState(".")), (ICommand) macroCommand);

        //START --> ,
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState(",")), (ICommand) macroCommand);

//      START --> :
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState(":")), (ICommand) macroCommand);

        //START --> [
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("[")), (ICommand) macroCommand);

        //START --> ]
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("]")), (ICommand) macroCommand);

        //START --> `
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("`")), (ICommand) macroCommand);

        //START --> ~
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("~")), (ICommand) macroCommand);

        //START --> <
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("<")), (ICommand) macroCommand);

        //START --> >
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState(">")), (ICommand) macroCommand);

//      START --> STRING
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("STRING")), (ICommand) macroCommand);

//      STRING --> STRING
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("STRING"), new FormatterState("STRING")), (ICommand) macroCommand);

//      STRING --> START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("STRING"), new FormatterState("START")), (ICommand) macroCommand);

//      START --> CHAR
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("CHAR")), (ICommand) macroCommand);

//      CHAR --> CHAR
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("CHAR"), new FormatterState("CHAR")), (ICommand) macroCommand);

//      CHAR --> START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("CHAR"), new FormatterState("START")), (ICommand) macroCommand);

//==================================================================================================================================

//      IGNORE_SPACES --> IGNORE_SPACES
        this.commands.put(new FormatterStatesPair(new FormatterState("IGNORE_SPACES"), new FormatterState("IGNORE_SPACES")), commandReadNextToken);

//==========================================================================================================================================

//      START --> COMMENT_MANY_LINES
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("COMMENT_MANY_LINES")), (ICommand) macroCommand);

//      COMMENT_MANY_LINES --> COMMENT_MANY_LINES
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_MANY_LINES"), new FormatterState("COMMENT_MANY_LINES")), (ICommand) macroCommand);

//      COMMENT_MANY_LINES  --->  COMMENT_MANY_LINES_END
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandAddNewLineToBuffer);
        macroCommand.addNewCommand(commandAddIndentToBuffer);
        macroCommand.addNewCommand(commandSetMarkToTheNextPositionToAdd);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_MANY_LINES"), new FormatterState("COMMENT_MANY_LINES_END")), (ICommand) macroCommand);

//      COMMENT_MANY_LINES_END  --->  COMMENT_MANY_LINES_END->NEW_LINE_IGNORE_ONCE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_MANY_LINES_END"), new FormatterState("COMMENT_MANY_LINES_END->NEW_LINE_IGNORE_ONCE")), (ICommand) macroCommand);

//      COMMENT_MANY_LINES_END  --->  COMMENT_ONE_LINE_START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteCurrentIndentSizeFromBuffer);
        macroCommand.addNewCommand(commandDeleteNewLineFromBuffer);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_MANY_LINES_END"), new FormatterState("COMMENT_ONE_LINE_START")), (ICommand) macroCommand);

//      COMMENT_MANY_LINES_END  --->  COMMENT_MANY_LINES
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteCurrentIndentSizeFromBuffer);
        macroCommand.addNewCommand(commandDeleteNewLineFromBuffer);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_MANY_LINES_END"), new FormatterState("COMMENT_MANY_LINES")), (ICommand) macroCommand);

//      COMMENT_MANY_LINES_END->SPACE_ADDING  --->  COMMENT_MANY_LINES_END->NEW_LINE_IGNORE_ONCE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteAllCharsFromCurrentPositionToMarkPosition);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_MANY_LINES_END->SPACE_ADDING"), new FormatterState("COMMENT_MANY_LINES_END->NEW_LINE_IGNORE_ONCE")), (ICommand) macroCommand);

//      COMMENT_MANY_LINES_END->SPACE_ADDING  --->  COMMENT_MANY_LINES_END->SPACE_ADDING
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_MANY_LINES_END->SPACE_ADDING"), new FormatterState("COMMENT_MANY_LINES_END->SPACE_ADDING")), (ICommand) macroCommand);

//      COMMENT_MANY_LINES_END->SPACE_ADDING  --->  START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteAllCharsFromCurrentPositionToMarkPosition);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_MANY_LINES_END->SPACE_ADDING"), new FormatterState("START")), (ICommand) macroCommand);

//      COMMENT_MANY_LINES_END->SPACE_ADDING  --->  COMMENT_ONE_LINE_START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentAndNewLineBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_MANY_LINES_END->SPACE_ADDING"), new FormatterState("COMMENT_ONE_LINE_START")), (ICommand) macroCommand);

//      COMMENT_MANY_LINES_END->SPACE_ADDING  --->  COMMENT_MANY_LINES
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentAndNewLineBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_MANY_LINES_END->SPACE_ADDING"), new FormatterState("COMMENT_MANY_LINES")), (ICommand) macroCommand);

//      COMMENT_MANY_LINES_END->NEW_LINE_IGNORE_ONCE  --->  COMMENT_MANY_LINES_END->NEW_LINE_ADDING
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandAddIndentToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_MANY_LINES_END->NEW_LINE_IGNORE_ONCE"), new FormatterState("COMMENT_MANY_LINES_END->NEW_LINE_ADDING")), (ICommand) macroCommand);

//      COMMENT_MANY_LINES_END->NEW_LINE_IGNORE_ONCE  --->  COMMENT_MANY_LINES_END->NEW_LINE->SPACE_ADDING
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_MANY_LINES_END->NEW_LINE_IGNORE_ONCE"), new FormatterState("COMMENT_MANY_LINES_END->NEW_LINE->SPACE_ADDING")), (ICommand) macroCommand);

//      COMMENT_MANY_LINES_END->NEW_LINE_IGNORE_ONCE  --->  COMMENT_ONE_LINE_START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_MANY_LINES_END->NEW_LINE_IGNORE_ONCE"), new FormatterState("COMMENT_ONE_LINE_START")), (ICommand) macroCommand);

//      COMMENT_MANY_LINES_END->NEW_LINE_IGNORE_ONCE  --->  COMMENT_MANY_LINES
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_MANY_LINES_END->NEW_LINE_IGNORE_ONCE"), new FormatterState("COMMENT_MANY_LINES")), (ICommand) macroCommand);

//      COMMENT_MANY_LINES_END->NEW_LINE_ADDING  --->  COMMENT_MANY_LINES_END->NEW_LINE_ADDING
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandAddIndentToBuffer);
        macroCommand.addNewCommand(commandSetMarkToTheNextPositionToAdd);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_MANY_LINES_END->NEW_LINE_ADDING"), new FormatterState("COMMENT_MANY_LINES_END->NEW_LINE_ADDING")), (ICommand) macroCommand);

//      COMMENT_MANY_LINES_END->NEW_LINE_ADDING  --->  COMMENT_MANY_LINES_END->NEW_LINE->SPACE_ADDING
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_MANY_LINES_END->NEW_LINE_ADDING"), new FormatterState("COMMENT_MANY_LINES_END->NEW_LINE->SPACE_ADDING")), (ICommand) macroCommand);

//      COMMENT_MANY_LINES_END->NEW_LINE_ADDING  --->  COMMENT_ONE_LINE_START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_MANY_LINES_END->NEW_LINE_ADDING"), new FormatterState("COMMENT_ONE_LINE_START")), (ICommand) macroCommand);

//      COMMENT_MANY_LINES_END->NEW_LINE_ADDING  --->  COMMENT_MANY_LINES
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_MANY_LINES_END->NEW_LINE_ADDING"), new FormatterState("COMMENT_MANY_LINES")), (ICommand) macroCommand);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_MANY_LINES_END->NEW_LINE->SPACE_SET_MARK"), new FormatterState("COMMENT_MANY_LINES_END->NEW_LINE_ADDING")), (ICommand) macroCommand);

//      COMMENT_MANY_LINES_END->NEW_LINE->SPACE_ADDING  --->  COMMENT_MANY_LINES_END->NEW_LINE_ADDING
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteAllCharsFromCurrentPositionToMarkPosition);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_MANY_LINES_END->NEW_LINE->SPACE_SET_MARK"), new FormatterState("COMMENT_MANY_LINES_END->NEW_LINE_ADDING")), (ICommand) macroCommand);

//      COMMENT_MANY_LINES_END->NEW_LINE->SPACE_ADDING  --->  COMMENT_MANY_LINES_END->NEW_LINE->SPACE_ADDING
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_MANY_LINES_END->NEW_LINE->SPACE_ADDING"), new FormatterState("COMMENT_MANY_LINES_END->NEW_LINE->SPACE_ADDING")), (ICommand) macroCommand);

//      COMMENT_MANY_LINES_END->NEW_LINE->SPACE_ADDING  --->  COMMENT_ONE_LINE_START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_MANY_LINES_END->NEW_LINE->SPACE_ADDING"), new FormatterState("COMMENT_ONE_LINE_START")), (ICommand) macroCommand);

//      COMMENT_MANY_LINES_END->NEW_LINE->SPACE_ADDING  --->  COMMENT_MANY_LINES
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_MANY_LINES_END->NEW_LINE->SPACE_ADDING"), new FormatterState("COMMENT_MANY_LINES")), (ICommand) macroCommand);

//      COMMENT_MANY_LINES_END->NEW_LINE->SPACE_ADDING  --->  START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteAllCharsFromCurrentPositionToMarkPosition);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_MANY_LINES_END->NEW_LINE->SPACE_ADDING"), new FormatterState("START")), (ICommand) macroCommand);

//=================================================================================================

//      START  --->  ;
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandAddNewLineToBuffer);
        macroCommand.addNewCommand(commandAddIndentToBuffer);
        macroCommand.addNewCommand(commandSetMarkToTheNextPositionToAdd);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState(";")), (ICommand) macroCommand);

//      ;  --->  ;->NEW_LINE_IGNORE_ONCE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState(";"), new FormatterState(";->NEW_LINE_IGNORE_ONCE")), (ICommand) macroCommand);

//      ;  --->  COMMENT_ONE_LINE_START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteCurrentIndentSizeFromBuffer);
        macroCommand.addNewCommand(commandDeleteNewLineFromBuffer);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState(";"), new FormatterState("COMMENT_ONE_LINE_START")), (ICommand) macroCommand);

//      ;  --->  COMMENT_MANY_LINES
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteCurrentIndentSizeFromBuffer);
        macroCommand.addNewCommand(commandDeleteNewLineFromBuffer);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState(";"), new FormatterState("COMMENT_MANY_LINES")), (ICommand) macroCommand);

//      ;->SPACE_ADDING  --->  ;->NEW_LINE_IGNORE_ONCE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteAllCharsFromCurrentPositionToMarkPosition);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState(";->SPACE_ADDING"), new FormatterState(";->NEW_LINE_IGNORE_ONCE")), (ICommand) macroCommand);

//      ;->SPACE_ADDING  --->  ;->SPACE_ADDING
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState(";->SPACE_ADDING"), new FormatterState(";->SPACE_ADDING")), (ICommand) macroCommand);

//      ;->SPACE_ADDING  --->  COMMENT_ONE_LINE_START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentAndNewLineBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState(";->SPACE_ADDING"), new FormatterState("COMMENT_ONE_LINE_START")), (ICommand) macroCommand);

//      ;->SPACE_ADDING  --->  COMMENT_MANY_LINES
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentAndNewLineBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState(";->SPACE_ADDING"), new FormatterState("COMMENT_MANY_LINES")), (ICommand) macroCommand);

//      ;->SPACE_ADDING  --->  START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteAllCharsFromCurrentPositionToMarkPosition);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState(";->SPACE_ADDING"), new FormatterState("START")), (ICommand) macroCommand);


//      ;->NEW_LINE_IGNORE_ONCE  --->  ;->NEW_LINE_ADDING
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandAddIndentToBuffer);
        macroCommand.addNewCommand(commandSetMarkToTheNextPositionToAdd);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState(";->NEW_LINE_IGNORE_ONCE"), new FormatterState(";->NEW_LINE_ADDING")), (ICommand) macroCommand);

//      ;->NEW_LINE_IGNORE_ONCE  --->  ;->NEW_LINE->SPACE_ADDING
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState(";->NEW_LINE_IGNORE_ONCE"), new FormatterState(";->NEW_LINE->SPACE_ADDING")), (ICommand) macroCommand);

//      ;->NEW_LINE_IGNORE_ONCE  --->  COMMENT_ONE_LINE_START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState(";->NEW_LINE_IGNORE_ONCE"), new FormatterState("COMMENT_ONE_LINE_START")), (ICommand) macroCommand);

//      ;->NEW_LINE_IGNORE_ONCE  --->  COMMENT_MANY_LINES
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState(";->NEW_LINE_IGNORE_ONCE"), new FormatterState("COMMENT_MANY_LINES")), (ICommand) macroCommand);

//      ;->NEW_LINE_ADDING  --->  ;->NEW_LINE_ADDING
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandAddIndentToBuffer);
        macroCommand.addNewCommand(commandSetMarkToTheNextPositionToAdd);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState(";->NEW_LINE_ADDING"), new FormatterState(";->NEW_LINE_ADDING")), (ICommand) macroCommand);

//      ;->NEW_LINE_ADDING  --->  ;->NEW_LINE->SPACE_ADDING
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        this.commands.put(new FormatterStatesPair(new FormatterState(";->NEW_LINE_ADDING"), new FormatterState(";->NEW_LINE->SPACE_ADDING")), (ICommand) macroCommand);

//      ;->NEW_LINE_ADDING  --->  COMMENT_ONE_LINE_START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState(";->NEW_LINE_ADDING"), new FormatterState("COMMENT_ONE_LINE_START")), (ICommand) macroCommand);

//      ;->NEW_LINE_ADDING  --->  COMMENT_MANY_LINES
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState(";->NEW_LINE_ADDING"), new FormatterState("COMMENT_MANY_LINES")), (ICommand) macroCommand);
        this.commands.put(new FormatterStatesPair(new FormatterState(";->NEW_LINE->SPACE_SET_MARK"), new FormatterState(";->NEW_LINE_ADDING")), (ICommand) macroCommand);

//      ;->NEW_LINE->SPACE_ADDING  --->  ;->NEW_LINE_ADDING
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteAllCharsFromCurrentPositionToMarkPosition);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState(";->NEW_LINE->SPACE_SET_MARK"), new FormatterState(";->NEW_LINE_ADDING")), (ICommand) macroCommand);

//      ;->NEW_LINE->SPACE_ADDING  --->  ;->NEW_LINE->SPACE_ADDING
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState(";->NEW_LINE->SPACE_ADDING"), new FormatterState(";->NEW_LINE->SPACE_ADDING")), (ICommand) macroCommand);

//      ;->NEW_LINE->SPACE_ADDING  --->  COMMENT_ONE_LINE_START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState(";->NEW_LINE->SPACE_ADDING"), new FormatterState("COMMENT_ONE_LINE_START")), (ICommand) macroCommand);

//      ;->NEW_LINE->SPACE_ADDING  --->  COMMENT_MANY_LINES
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState(";->NEW_LINE->SPACE_ADDING"), new FormatterState("COMMENT_MANY_LINES")), (ICommand) macroCommand);

//      ;->NEW_LINE->SPACE_ADDING  --->  START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteAllCharsFromCurrentPositionToMarkPosition);
        this.commands.put(new FormatterStatesPair(new FormatterState(";->NEW_LINE->SPACE_ADDING"), new FormatterState("START")), (ICommand) macroCommand);

//=================================================================================================

//      START --> COMMENT_ONE_LINE_START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("COMMENT_ONE_LINE_START")), (ICommand) macroCommand);

//      COMMENT_ONE_LINE_START  --->  COMMENT_ONE_LINE_END
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandAddIndentToBuffer);
        macroCommand.addNewCommand(commandSetMarkToTheNextPositionToAdd);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_ONE_LINE_START"), new FormatterState("COMMENT_ONE_LINE_END")), (ICommand) macroCommand);


//      COMMENT_ONE_LINE_START --> COMMENT_ONE_LINE_START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_ONE_LINE_START"), new FormatterState("COMMENT_ONE_LINE_START")), (ICommand) macroCommand);

//      COMMENT_ONE_LINE_END  --->  COMMENT_ONE_LINE_END->NEW_LINE_IGNORE_ONCE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_ONE_LINE_END"), new FormatterState("COMMENT_ONE_LINE_END->NEW_LINE_IGNORE_ONCE")), (ICommand) macroCommand);

//      COMMENT_ONE_LINE_END  --->  COMMENT_ONE_LINE_START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteCurrentIndentSizeFromBuffer);
        macroCommand.addNewCommand(commandDeleteNewLineFromBuffer);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_ONE_LINE_END"), new FormatterState("COMMENT_ONE_LINE_START")), (ICommand) macroCommand);

//      COMMENT_ONE_LINE_END  --->  COMMENT_MANY_LINES
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteCurrentIndentSizeFromBuffer);
        macroCommand.addNewCommand(commandDeleteNewLineFromBuffer);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_ONE_LINE_END"), new FormatterState("COMMENT_MANY_LINES")), (ICommand) macroCommand);

//      COMMENT_ONE_LINE_END->SPACE_ADDING  --->  COMMENT_ONE_LINE_END->NEW_LINE_IGNORE_ONCE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteAllCharsFromCurrentPositionToMarkPosition);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_ONE_LINE_END->SPACE_ADDING"), new FormatterState("COMMENT_ONE_LINE_END->NEW_LINE_IGNORE_ONCE")), (ICommand) macroCommand);

//      COMMENT_ONE_LINE_END->SPACE_ADDING  --->  COMMENT_ONE_LINE_END->SPACE_ADDING
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_ONE_LINE_END->SPACE_ADDING"), new FormatterState("COMMENT_ONE_LINE_END->SPACE_ADDING")), (ICommand) macroCommand);

//      COMMENT_ONE_LINE_END->SPACE_ADDING  --->  START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteAllCharsFromCurrentPositionToMarkPosition);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_ONE_LINE_END->SPACE_ADDING"), new FormatterState("START")), (ICommand) macroCommand);

//      COMMENT_ONE_LINE_END->SPACE_ADDING  --->  COMMENT_ONE_LINE_START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentAndNewLineBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_ONE_LINE_END->SPACE_ADDING"), new FormatterState("COMMENT_ONE_LINE_START")), (ICommand) macroCommand);

//      COMMENT_ONE_LINE_END->SPACE_ADDING  --->  COMMENT_MANY_LINES
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentAndNewLineBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_ONE_LINE_END->SPACE_ADDING"), new FormatterState("COMMENT_MANY_LINES")), (ICommand) macroCommand);

//      COMMENT_ONE_LINE_END->NEW_LINE_IGNORE_ONCE  --->  COMMENT_ONE_LINE_END->NEW_LINE_ADDING
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandAddIndentToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_ONE_LINE_END->NEW_LINE_IGNORE_ONCE"), new FormatterState("COMMENT_ONE_LINE_END->NEW_LINE_ADDING")), (ICommand) macroCommand);

//      COMMENT_ONE_LINE_END->NEW_LINE_IGNORE_ONCE  --->  COMMENT_ONE_LINE_END->NEW_LINE->SPACE_ADDING
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_ONE_LINE_END->NEW_LINE_IGNORE_ONCE"), new FormatterState("COMMENT_ONE_LINE_END->NEW_LINE->SPACE_ADDING")), (ICommand) macroCommand);

//      COMMENT_ONE_LINE_END->NEW_LINE_IGNORE_ONCE  --->  COMMENT_ONE_LINE_START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_ONE_LINE_END->NEW_LINE_IGNORE_ONCE"), new FormatterState("COMMENT_ONE_LINE_START")), (ICommand) macroCommand);

//      COMMENT_ONE_LINE_END->NEW_LINE_IGNORE_ONCE  --->  COMMENT_MANY_LINES
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_ONE_LINE_END->NEW_LINE_IGNORE_ONCE"), new FormatterState("COMMENT_MANY_LINES")), (ICommand) macroCommand);

//      COMMENT_ONE_LINE_END->NEW_LINE_ADDING  --->  COMMENT_ONE_LINE_END->NEW_LINE_ADDING
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandAddIndentToBuffer);
        macroCommand.addNewCommand(commandSetMarkToTheNextPositionToAdd);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_ONE_LINE_END->NEW_LINE_ADDING"), new FormatterState("COMMENT_ONE_LINE_END->NEW_LINE_ADDING")), (ICommand) macroCommand);

//      COMMENT_ONE_LINE_END->NEW_LINE_ADDING  --->  COMMENT_ONE_LINE_END->NEW_LINE->SPACE_ADDING
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_ONE_LINE_END->NEW_LINE_ADDING"), new FormatterState("COMMENT_ONE_LINE_END->NEW_LINE->SPACE_ADDING")), (ICommand) macroCommand);

//      COMMENT_ONE_LINE_END->NEW_LINE_ADDING  --->  COMMENT_ONE_LINE_START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_ONE_LINE_END->NEW_LINE_ADDING"), new FormatterState("COMMENT_ONE_LINE_START")), (ICommand) macroCommand);

//      COMMENT_ONE_LINE_END->NEW_LINE_ADDING  --->  COMMENT_MANY_LINES
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_ONE_LINE_END->NEW_LINE_ADDING"), new FormatterState("COMMENT_MANY_LINES")), (ICommand) macroCommand);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_ONE_LINE_END->NEW_LINE->SPACE_SET_MARK"), new FormatterState("COMMENT_ONE_LINE_END->NEW_LINE_ADDING")), (ICommand) macroCommand);

//      COMMENT_ONE_LINE_END->NEW_LINE->SPACE_ADDING  --->  COMMENT_ONE_LINE_END->NEW_LINE_ADDING
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteAllCharsFromCurrentPositionToMarkPosition);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_ONE_LINE_END->NEW_LINE->SPACE_SET_MARK"), new FormatterState("COMMENT_ONE_LINE_END->NEW_LINE_ADDING")), (ICommand) macroCommand);

//      COMMENT_ONE_LINE_END->NEW_LINE->SPACE_ADDING  --->  COMMENT_ONE_LINE_END->NEW_LINE->SPACE_ADDING
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_ONE_LINE_END->NEW_LINE->SPACE_ADDING"), new FormatterState("COMMENT_ONE_LINE_END->NEW_LINE->SPACE_ADDING")), (ICommand) macroCommand);

//      COMMENT_ONE_LINE_END->NEW_LINE->SPACE_ADDING  --->  COMMENT_ONE_LINE_START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_ONE_LINE_END->NEW_LINE->SPACE_ADDING"), new FormatterState("COMMENT_ONE_LINE_START")), (ICommand) macroCommand);

//      COMMENT_ONE_LINE_END->NEW_LINE->SPACE_ADDING  --->  COMMENT_MANY_LINES
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_ONE_LINE_END->NEW_LINE->SPACE_ADDING"), new FormatterState("COMMENT_MANY_LINES")), (ICommand) macroCommand);

//      COMMENT_ONE_LINE_END->NEW_LINE->SPACE_ADDING  --->  START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteAllCharsFromCurrentPositionToMarkPosition);
        this.commands.put(new FormatterStatesPair(new FormatterState("COMMENT_ONE_LINE_END->NEW_LINE->SPACE_ADDING"), new FormatterState("START")), (ICommand) macroCommand);

//=================================================================================================

//      START  --->  {
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandAddNewLineToBuffer);
        macroCommand.addNewCommand(commandIncreaseIndent);
        macroCommand.addNewCommand(commandAddIndentToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("{")), (ICommand) macroCommand);

//      {  --->  {->SPACE|NEW_LINE
        this.commands.put(new FormatterStatesPair(new FormatterState("{"), new FormatterState("{->SPACE|NEW_LINE")), commandReadNextToken);

//      {  --->  COMMENT_ONE_LINE_START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteCurrentIndentSizeFromBuffer);
        macroCommand.addNewCommand(commandDeleteNewLineFromBuffer);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("{"), new FormatterState("COMMENT_ONE_LINE_START")), (ICommand) macroCommand);

//      {  --->  COMMENT_MANY_LINES
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteCurrentIndentSizeFromBuffer);
        macroCommand.addNewCommand(commandDeleteNewLineFromBuffer);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("{"), new FormatterState("COMMENT_MANY_LINES")), (ICommand) macroCommand);

//      {->SPACE|NEW_LINE  --->  {->SPACE|NEW_LINE
        this.commands.put(new FormatterStatesPair(new FormatterState("{->SPACE|NEW_LINE"), new FormatterState("{->SPACE|NEW_LINE")), commandReadNextToken);

//      {  --->  {->SPACE_SET_MARK
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandSetMarkToTheNextPositionToAdd);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("{"), new FormatterState("{->SPACE_SET_MARK")), (ICommand) macroCommand);

//      {->SPACE_SET_MARK  --->  COMMENT_ONE_LINE_START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentAndNewLineBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("{->SPACE_SET_MARK"), new FormatterState("COMMENT_ONE_LINE_START")), (ICommand) macroCommand);

//      {->SPACE_SET_MARK  --->  COMMENT_MANY_LINES
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentAndNewLineBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("{->SPACE_SET_MARK"), new FormatterState("COMMENT_MANY_LINES")), (ICommand) macroCommand);

//      {->SPACE_SET_MARK  --->  {->SPACE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("{->SPACE_SET_MARK"), new FormatterState("{->SPACE")), (ICommand) macroCommand);

//      {->SPACE_SET_MARK  --->  {->SPACE|NEW_LINE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteAllCharsFromCurrentPositionToMarkPosition);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("{->SPACE_SET_MARK"), new FormatterState("{->SPACE|NEW_LINE")), (ICommand) macroCommand);

//      {->SPACE  --->  {->SPACE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("{->SPACE"), new FormatterState("{->SPACE")), (ICommand) macroCommand);

//      {->SPACE  --->  COMMENT_ONE_LINE_START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentAndNewLineBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("{->SPACE"), new FormatterState("COMMENT_ONE_LINE_START")), (ICommand) macroCommand);

//      {->SPACE  --->  COMMENT_MANY_LINES
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentAndNewLineBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("{->SPACE"), new FormatterState("COMMENT_MANY_LINES")), (ICommand) macroCommand);

//      {->SPACE  --->  {->SPACE|NEW_LINE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteAllCharsFromCurrentPositionToMarkPosition);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("{->SPACE"), new FormatterState("{->SPACE|NEW_LINE")), (ICommand) macroCommand);

//=================================================================================================

//      START  --->  }
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteStandardIndentSizeFromBuffer);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandAddNewLineToBuffer);
        macroCommand.addNewCommand(commandDecreaseIndent);
        macroCommand.addNewCommand(commandAddIndentToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("}")), (ICommand) macroCommand);

//      }  --->  }->SPACE|NEW_LINE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandSetMarkToTheNextPositionToAdd);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("}"), new FormatterState("}->SPACE|NEW_LINE")), (ICommand) macroCommand);

//      }  --->  COMMENT_ONE_LINE_START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteCurrentIndentSizeFromBuffer);
        macroCommand.addNewCommand(commandDeleteNewLineFromBuffer);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("}"), new FormatterState("COMMENT_ONE_LINE_START")), (ICommand) macroCommand);

//      }  --->  COMMENT_MANY_LINES
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteCurrentIndentSizeFromBuffer);
        macroCommand.addNewCommand(commandDeleteNewLineFromBuffer);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("}"), new FormatterState("COMMENT_MANY_LINES")), (ICommand) macroCommand);

//      }  --->  ELSE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteCurrentIndentSizeFromBuffer);
        macroCommand.addNewCommand(commandDeleteNewLineFromBuffer);
        macroCommand.addNewCommand(commandAddSpaceToBuffer);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("}"), new FormatterState("ELSE")), (ICommand) macroCommand);

//      }  --->  }->SPACE_SET_MARK
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandSetMarkToTheNextPositionToAdd);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("}"), new FormatterState("}->SPACE_SET_MARK")), (ICommand) macroCommand);

//      }->SPACE|NEW_LINE  --->  }->SPACE|NEW_LINE
        this.commands.put(new FormatterStatesPair(new FormatterState("}->SPACE|NEW_LINE"), new FormatterState("}->SPACE|NEW_LINE")), commandReadNextToken);

//      }->SPACE|NEW_LINE  --->  ELSE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentAndNewLineBeforeTheMark);
        macroCommand.addNewCommand(commandDeleteAllCharsFromCurrentPositionToMarkPosition);
        macroCommand.addNewCommand(commandAddSpaceToBuffer);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("}->SPACE|NEW_LINE"), new FormatterState("ELSE")), (ICommand) macroCommand);

//      }->SPACE_SET_MARK  --->  COMMENT_ONE_LINE_START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentAndNewLineBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("}->SPACE_SET_MARK"), new FormatterState("COMMENT_ONE_LINE_START")), (ICommand) macroCommand);

//      }->SPACE_SET_MARK  --->  COMMENT_MANY_LINES
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentAndNewLineBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("}->SPACE_SET_MARK"), new FormatterState("COMMENT_MANY_LINES")), (ICommand) macroCommand);

//      }->SPACE_SET_MARK  --->  ELSE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentAndNewLineBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("}->SPACE_SET_MARK"), new FormatterState("ELSE")), (ICommand) macroCommand);

//      }->SPACE_SET_MARK  --->  }->SPACE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("}->SPACE_SET_MARK"), new FormatterState("}->SPACE")), (ICommand) macroCommand);

//      }->SPACE_SET_MARK  --->  }->SPACE|NEW_LINE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteAllCharsFromCurrentPositionToMarkPosition);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("}->SPACE_SET_MARK"), new FormatterState("}->SPACE|NEW_LINE")), (ICommand) macroCommand);

//      }->SPACE  --->  }->SPACE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("}->SPACE"), new FormatterState("}->SPACE")), (ICommand) macroCommand);

//      }->SPACE  --->  COMMENT_ONE_LINE_START
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentAndNewLineBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("}->SPACE"), new FormatterState("COMMENT_ONE_LINE_START")), (ICommand) macroCommand);

//      }->SPACE  --->  COMMENT_MANY_LINES
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentAndNewLineBeforeTheMark);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("}->SPACE"), new FormatterState("COMMENT_MANY_LINES")), (ICommand) macroCommand);

//      }->SPACE  --->  ELSE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteIndentAndNewLineBeforeTheMark);
        macroCommand.addNewCommand(commandDeleteAllCharsFromCurrentPositionToMarkPosition);
        macroCommand.addNewCommand(commandAddSpaceToBuffer);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("}->SPACE"), new FormatterState("ELSE")), (ICommand) macroCommand);

//      }->SPACE  --->  }->SPACE|NEW_LINE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandDeleteAllCharsFromCurrentPositionToMarkPosition);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("}->SPACE"), new FormatterState("}->SPACE|NEW_LINE")), (ICommand) macroCommand);

//===============================================================================================================================

//IF_BEGIN
//START --> IF->SPACE->(...->(...)->SPACE --> {
        //START --> IF
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("IF")), (ICommand) macroCommand);
        //IF --> IF->SPACE->(...
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddSpaceToBuffer);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("IF"), new FormatterState("IF->SPACE->(...")), (ICommand) macroCommand);
        //IF --> IF->SPACE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("IF"), new FormatterState("IF->SPACE")), (ICommand) macroCommand);
        //IF->SPACE --> IF->SPACE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("IF->SPACE"), new FormatterState("IF->SPACE")), (ICommand) macroCommand);
        //IF->SPACE --> IF->SPACE->(...
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("IF->SPACE"), new FormatterState("IF->SPACE->(...")), (ICommand) macroCommand);

        //IF->SPACE->(... --> IF->SPACE->(...
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("IF->SPACE->(..."), new FormatterState("IF->SPACE->(...")), (ICommand) macroCommand);

        //IF->SPACE->(... --> IF->SPACE->(...->(...)
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("IF->SPACE->(..."), new FormatterState("IF->SPACE->(...->(...)")), (ICommand) macroCommand);

        //IF->SPACE->(...->(...) --> {
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddSpaceToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        this.commands.put(new FormatterStatesPair(new FormatterState("IF->SPACE->(...->(...)"), new FormatterState("{")), (ICommand) macroCommand);

        //IF->SPACE->(...->(...) --> IF->SPACE->(...->(...)->SPACE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("IF->SPACE->(...->(...)"), new FormatterState("IF->SPACE->(...->(...)->SPACE")), (ICommand) macroCommand);

        //IF->SPACE->(...->(...)->SPACE --> IF->SPACE->(...->(...)->SPACE
        this.commands.put(new FormatterStatesPair(new FormatterState("IF->SPACE->(...->(...)->SPACE"), new FormatterState("IF->SPACE->(...->(...)->SPACE")), commandReadNextToken);

        //IF->SPACE->(...->(...)->SPACE --> {
        this.commands.put(new FormatterStatesPair(new FormatterState("IF->SPACE->(...->(...)->SPACE"), new FormatterState("{")), commandFormatterDefault);
//IF_END

//WHILE_BEGIN
//START --> WHILE->SPACE->(...->(...)->SPACE --> {
        //START --> WHILE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("WHILE")), (ICommand) macroCommand);
        //WHILE --> WHILE->SPACE->(...
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddSpaceToBuffer);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("WHILE"), new FormatterState("WHILE->SPACE->(...")), (ICommand) macroCommand);
        //WHILE --> WHILE->SPACE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("WHILE"), new FormatterState("WHILE->SPACE")), (ICommand) macroCommand);
        //WHILE->SPACE --> WHILE->SPACE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("WHILE->SPACE"), new FormatterState("WHILE->SPACE")), (ICommand) macroCommand);
        //WHILE->SPACE --> WHILE->SPACE->(...
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("WHILE->SPACE"), new FormatterState("WHILE->SPACE->(...")), (ICommand) macroCommand);

        //WHILE->SPACE->(... --> WHILE->SPACE->(...
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("WHILE->SPACE->(..."), new FormatterState("WHILE->SPACE->(...")), (ICommand) macroCommand);

        //WHILE->SPACE->(... --> WHILE->SPACE->(...->(...)
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("WHILE->SPACE->(..."), new FormatterState("WHILE->SPACE->(...->(...)")), (ICommand) macroCommand);

        //WHILE->SPACE->(...->(...) --> {
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddSpaceToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        this.commands.put(new FormatterStatesPair(new FormatterState("WHILE->SPACE->(...->(...)"), new FormatterState("{")), (ICommand) macroCommand);

        //WHILE->SPACE->(...->(...) --> WHILE->SPACE->(...->(...)->SPACE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("WHILE->SPACE->(...->(...)"), new FormatterState("WHILE->SPACE->(...->(...)->SPACE")), (ICommand) macroCommand);

        //WHILE->SPACE->(...->(...)->SPACE --> WHILE->SPACE->(...->(...)->SPACE
        this.commands.put(new FormatterStatesPair(new FormatterState("WHILE->SPACE->(...->(...)->SPACE"), new FormatterState("WHILE->SPACE->(...->(...)->SPACE")), commandReadNextToken);

        //WHILE->SPACE->(...->(...)->SPACE --> {
        this.commands.put(new FormatterStatesPair(new FormatterState("WHILE->SPACE->(...->(...)->SPACE"), new FormatterState("{")), commandFormatterDefault);
//WHILE_END

//FOR_BEGIN
//START --> FOR->SPACE->(...->(...)->SPACE --> {
        //START --> FOR
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("START"), new FormatterState("FOR")), (ICommand) macroCommand);
        //FOR --> FOR->SPACE->(...
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddSpaceToBuffer);
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("FOR"), new FormatterState("FOR->SPACE->(...")), (ICommand) macroCommand);
        //FOR --> FOR->SPACE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("FOR"), new FormatterState("FOR->SPACE")), (ICommand) macroCommand);

        //FOR->SPACE --> FOR->SPACE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("FOR->SPACE"), new FormatterState("FOR->SPACE")), (ICommand) macroCommand);

        //FOR->SPACE --> FOR->SPACE->(...
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("FOR->SPACE"), new FormatterState("FOR->SPACE->(...")), (ICommand) macroCommand);

        //FOR->SPACE->(... --> FOR->SPACE->(...
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("FOR->SPACE->(..."), new FormatterState("FOR->SPACE->(...")), (ICommand) macroCommand);

        //FOR->SPACE->(... --> FOR->SPACE->(.;.
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandAddSpaceToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("FOR->SPACE->(..."), new FormatterState("FOR->SPACE->(.;.")), (ICommand) macroCommand);

        //FOR->SPACE->(.;. --> FOR->SPACE->(.;.->SPACE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("FOR->SPACE->(.;."), new FormatterState("FOR->SPACE->(.;.->SPACE")), (ICommand) macroCommand);

        //FOR->SPACE->(.;.->SPACE --> FOR->SPACE->(.;.->SPACE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("FOR->SPACE->(.;.->SPACE"), new FormatterState("FOR->SPACE->(.;.->SPACE")), (ICommand) macroCommand);

        //FOR->SPACE->(... --> FOR->SPACE->(...->(...)
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("FOR->SPACE->(..."), new FormatterState("FOR->SPACE->(...->(...)")), (ICommand) macroCommand);

        //FOR->SPACE->(...->(...) --> {
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddSpaceToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        this.commands.put(new FormatterStatesPair(new FormatterState("FOR->SPACE->(...->(...)"), new FormatterState("{")), (ICommand) macroCommand);

        //FOR->SPACE->(...->(...) --> FOR->SPACE->(...->(...)->SPACE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandAddTokenToBuffer);
        macroCommand.addNewCommand(commandWriteBuffer);
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("FOR->SPACE->(...->(...)"), new FormatterState("FOR->SPACE->(...->(...)->SPACE")), (ICommand) macroCommand);

        //FOR->SPACE->(...->(...)->SPACE --> FOR->SPACE->(...->(...)->SPACE
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandReadNextToken);
        this.commands.put(new FormatterStatesPair(new FormatterState("FOR->SPACE->(...->(...)->SPACE"), new FormatterState("FOR->SPACE->(...->(...)->SPACE")), (ICommand) macroCommand);

        //FOR->SPACE->(...->(...)->SPACE --> {
        macroCommand = new MacroCommand();
        macroCommand.addNewCommand(commandWriteBuffer);
        this.commands.put(new FormatterStatesPair(new FormatterState("FOR->SPACE->(...->(...)->SPACE"), new FormatterState("{")), (ICommand) macroCommand);
//FOR_END
    }

    @Override
    public ICommand getCommand() {
        return this.commands.getOrDefault(
                new FormatterStatesPair(this.formatter.getCurrentState(), this.formatter.getNextState()), commandFormatterDefault);
    }

    @Override
    public void setFormatter(final IFormatterDataAccess formatterDataAccess) {
        this.formatter = formatterDataAccess;
        fillUpActionTable();
    }
}
