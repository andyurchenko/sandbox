package it.sevenbits;

import it.sevenbits.formatter.Formatter;
import it.sevenbits.formatter.command.factory.FormatterCommandFactory;
import it.sevenbits.formatter.command.factory.IFormatterCommandFactory;
import it.sevenbits.formatter.fsm.FormatterEvent;
import it.sevenbits.formatter.fsm.FormatterState;
import it.sevenbits.formatter.fsm.factory.FormatterStateFactory;
import it.sevenbits.formatter.fsm.factory.IFormatterStateFactory;
import it.sevenbits.formatter.fsm.factory.config.FormatterDefaultStateTableCreator;
import it.sevenbits.formatter.fsm.factory.config.FormatterTransitionTableCreator;
import it.sevenbits.formatter.fsm.factory.config.IFormatterDefaultStateTableCreator;
import it.sevenbits.formatter.fsm.factory.config.IFormatterTransitionTableCreator;
import it.sevenbits.lexer.command.factory.LexerCommandFactory;
import it.sevenbits.lexer.command.factory.ILexerCommandFactory;
import it.sevenbits.lexer.fsm.LexerEvent;
import it.sevenbits.lexer.fsm.LexerState;
import it.sevenbits.lexer.fsm.factory.ILexerStateFactory;
import it.sevenbits.lexer.fsm.factory.LexerStateFactory;
import it.sevenbits.lexer.ILexer;
import it.sevenbits.lexer.Lexer;
import it.sevenbits.lexer.fsm.factory.config.LexerTransitionTableCreator;
import it.sevenbits.lexer.fsm.factory.config.ILexerTransitionTableCreator;
import it.sevenbits.tool.reader.ReaderFromFile;
import it.sevenbits.tool.reader.WholeFileReader;
import it.sevenbits.tool.reader.IReader;
import it.sevenbits.lexer.token.ITokenType;
import it.sevenbits.lexer.token.TokenType;
import it.sevenbits.lexer.token.reader.ConfigFileReaderForTokenType;
import it.sevenbits.lexer.token.reader.IConfigReaderForTokenType;
import it.sevenbits.tool.reader.IWholeFileReader;
import it.sevenbits.tool.writer.IWriter;
import it.sevenbits.tool.writer.WriterToFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * The type Main.
 */
public final class Main {

    private static final  int CORRECT_NUMBER_OF_INPUT_ARGUMENTS = 9;
    private static final  int LEXER_CONFIG = 0;
    private static final  int LEXER_TOKEN_CONFIG = 1;
    private static final  int LEXER_START_STATE = 2;
    private static final  int FORMATTER_CONFIG = 3;
    private static final  int FORMATTER_DEFAULT_STATE_CONFIG = 4;
    private static final  int FORMATTER_START_STATE = 5;
    private static final  int INDENT_SIZE = 6;
    private static final  int INPUT_FILE = 7;
    private static final  int OUTPUT_FILE = 8;

    private static Logger logger;

    private Main() {
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(final String[] args)  {
        logger = LoggerFactory.getLogger(Main.class);

        String pathToLexerConfig;
        String pathToLexerTokenConfig;
        String lexerStartState;

        String pathToFormatterConfig;
        String pathToFormatterDefaultStateConfig;
        String formatterStartState;

        String indentStandardSize;
        String inputFileNameWithCode;
        String outputFileNameWithCode;

        if (args.length == CORRECT_NUMBER_OF_INPUT_ARGUMENTS) {
            pathToLexerConfig = args[LEXER_CONFIG];
            pathToLexerTokenConfig = args[LEXER_TOKEN_CONFIG];
            lexerStartState = args[LEXER_START_STATE];
            pathToFormatterConfig = args[FORMATTER_CONFIG];
            pathToFormatterDefaultStateConfig = args[FORMATTER_DEFAULT_STATE_CONFIG];
            formatterStartState = args[FORMATTER_START_STATE];
            indentStandardSize = args[INDENT_SIZE];
            inputFileNameWithCode = args[INPUT_FILE];
            outputFileNameWithCode = args[OUTPUT_FILE];

        } else {
            pathToLexerConfig = "lexer_transition_table.json";
            pathToLexerTokenConfig = "config_token_type.json";
            lexerStartState = "START";

            pathToFormatterConfig = "formatter_transition_table.json";
            pathToFormatterDefaultStateConfig = "default_nextState_for_currentState_table.json";
            formatterStartState = "START";

            indentStandardSize = "4";
            inputFileNameWithCode = "in.txt";
            outputFileNameWithCode = "out.txt";
        }

        try (IReader fileReader = new ReaderFromFile(inputFileNameWithCode); IWriter writer = new WriterToFile(outputFileNameWithCode)) {
            IWholeFileReader wholeFileReader = new WholeFileReader();

            String config = wholeFileReader.readFile(pathToLexerConfig);
            ILexerTransitionTableCreator lexerTransitionTableCreator = new LexerTransitionTableCreator();
            final Map<LexerState, Map<LexerEvent, LexerState>> stateTransitionTable = lexerTransitionTableCreator.create(config);
            ILexerStateFactory lexerStateFactory = new LexerStateFactory(stateTransitionTable, lexerStartState);
            ILexerCommandFactory commandFactory = new LexerCommandFactory();
            IConfigReaderForTokenType configReaderForTokenType = new ConfigFileReaderForTokenType(pathToLexerTokenConfig);
            ITokenType tokenType = new TokenType(configReaderForTokenType);
            ILexer lexer = new Lexer(fileReader, commandFactory, lexerStateFactory, tokenType);

            IFormatterDefaultStateTableCreator defaultStateTableCreator = new FormatterDefaultStateTableCreator();
            config = wholeFileReader.readFile(pathToFormatterDefaultStateConfig);
            final Map<FormatterState, FormatterState> defaultStateTable = defaultStateTableCreator.create(config);
            config = wholeFileReader.readFile(pathToFormatterConfig);
            IFormatterTransitionTableCreator transitionTableCreator = new FormatterTransitionTableCreator();
            final Map<FormatterState, Map<FormatterEvent, FormatterState>> transitionTable = transitionTableCreator.create(config);
            IFormatterStateFactory formatterStateFactory = new FormatterStateFactory(transitionTable, defaultStateTable, formatterStartState);
            IFormatterCommandFactory formatterCommandFactory = new FormatterCommandFactory();
            Formatter formatter = new Formatter(lexer, writer, formatterStateFactory, formatterCommandFactory, Integer.parseInt(indentStandardSize));
            formatter.formatAndWriteToFile();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("DONE!");
    }


}