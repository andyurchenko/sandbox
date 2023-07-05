package it.sevenbits.courses.sm.commands.factory;

import it.sevenbits.courses.sm.commands.INetworkManagerCommand;
import it.sevenbits.courses.sm.commands.messages.*;
import it.sevenbits.courses.sm.manager.messages.MessageManager;
import it.sevenbits.courses.sm.manager.network.sm.Pair;
import it.sevenbits.courses.sm.manager.network.sm.NetworkState;
import it.sevenbits.courses.sm.network.NetworkPackageType;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Command repository.
 */
public class CommandRepository {
    /**
     * The Commands.
     */
    public Map<Pair<String, String>, INetworkManagerCommand> commands;

    private final Pair<String,  String> NEW_SESSION_MESSAGE = new Pair<>(NetworkState.NEW_SESSION, NetworkPackageType.MESSAGE);
    private final Pair<String,  String> NEW_SESSION_TRASH = new Pair<>(NetworkState.NEW_SESSION, NetworkPackageType.TRASH);
    private final Pair<String,  String> NEW_SESSION_MESSAGE_START = new Pair<>(NetworkState.NEW_SESSION, NetworkPackageType.MESSAGE_START);
    private final Pair<String,  String> NEW_SESSION_MESSAGE_FINISH = new Pair<>(NetworkState.NEW_SESSION, NetworkPackageType.MESSAGE_FINISH);

    private final Pair<String,  String> LISTEN_MESSAGE = new Pair<>(NetworkState.LISTEN, NetworkPackageType.MESSAGE);
    private final Pair<String,  String> LISTEN_TRASH = new Pair<>(NetworkState.LISTEN, NetworkPackageType.TRASH);
    private final Pair<String,  String> LISTEN_MESSAGE_START = new Pair<>(NetworkState.LISTEN, NetworkPackageType.MESSAGE_START);
    private final Pair<String,  String> LISTEN_MESSAGE_FINISH = new Pair<>(NetworkState.LISTEN, NetworkPackageType.MESSAGE_FINISH);

    private final Pair<String,  String> TRASH_SUSPICION_MESSAGE = new Pair<>(NetworkState.TRASH_SUSPICION, NetworkPackageType.MESSAGE);
    private final Pair<String,  String> TRASH_SUSPICION_TRASH = new Pair<>(NetworkState.TRASH_SUSPICION, NetworkPackageType.TRASH);
    private final Pair<String,  String> TRASH_SUSPICION_MESSAGE_START = new Pair<>(NetworkState.TRASH_SUSPICION, NetworkPackageType.MESSAGE_START);
    private final Pair<String,  String> TRASH_SUSPICION_MESSAGE_FINISH = new Pair<>(NetworkState.TRASH_SUSPICION, NetworkPackageType.MESSAGE_FINISH);

    private AddMessageCommand addMessageCommand;
    private PrintMessageCommand printMessageCommand;
    private ClearMessageBufferCommand clearMessageBufferCommand;
    private DoNothingCommand doNothingCommand;
    private INetworkManagerCommand[] commandsForMacro;
    private PrintMessageClearBufferMacrosCommand printMessageClearBufferMacrosCommand;


    /**
     * Instantiates a new Command repository.
     *
     * @param messageManager the message manager
     */
    public CommandRepository(final MessageManager messageManager) {
        commands = new HashMap<>();
        addMessageCommand = new AddMessageCommand(messageManager);
        printMessageCommand = new PrintMessageCommand(messageManager);
        clearMessageBufferCommand = new ClearMessageBufferCommand(messageManager);
        doNothingCommand = new DoNothingCommand();
        commandsForMacro = new INetworkManagerCommand[]{printMessageCommand, clearMessageBufferCommand};
        printMessageClearBufferMacrosCommand = new PrintMessageClearBufferMacrosCommand(commandsForMacro);

        commands.put(NEW_SESSION_MESSAGE, doNothingCommand);
        commands.put(NEW_SESSION_TRASH, doNothingCommand);
        commands.put(NEW_SESSION_MESSAGE_START, doNothingCommand);
        commands.put(NEW_SESSION_MESSAGE_FINISH, doNothingCommand);

        commands.put(LISTEN_MESSAGE, addMessageCommand);
        commands.put(LISTEN_TRASH, doNothingCommand);
        commands.put(LISTEN_MESSAGE_START, doNothingCommand);
        commands.put(LISTEN_MESSAGE_FINISH, printMessageCommand);

        commands.put(TRASH_SUSPICION_MESSAGE, addMessageCommand);
        commands.put(TRASH_SUSPICION_TRASH, clearMessageBufferCommand);
        commands.put(TRASH_SUSPICION_MESSAGE_START, clearMessageBufferCommand);
        commands.put(TRASH_SUSPICION_MESSAGE_FINISH, printMessageClearBufferMacrosCommand);
    }
}
