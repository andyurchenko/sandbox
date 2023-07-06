package it.sevenbits.courses.sm.manager.network.sm;

import it.sevenbits.courses.sm.commands.INetworkManagerCommand;
import it.sevenbits.courses.sm.commands.factory.CommandFactory;
import it.sevenbits.courses.sm.commands.factory.ICommandFactory;
import it.sevenbits.courses.sm.log.MessageFormatter;
import it.sevenbits.courses.sm.manager.network.INetworkManager;
import it.sevenbits.courses.sm.manager.network.NetworkManagerException;
import it.sevenbits.courses.sm.network.INetwork;
import it.sevenbits.courses.sm.network.NetworkPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type State machine network manager.
 */
public class StateMachineNetworkManager implements INetworkManager {

    private boolean isInterrupted = false;
    private final long TIMEOUT = 500;
    private final StateTransition stateTransition;
    private final Logger logger = LoggerFactory.getLogger(StateMachineNetworkManager.class);

    /**
     * Instantiates a new State machine network manager.
     */
    public StateMachineNetworkManager() {
        this.stateTransition = new StateTransition();
    }

    @Override
    public void listen(final INetwork network) throws NetworkManagerException {
        String currentState = stateTransition.getStartState();
        INetworkManagerCommand command;
        ICommandFactory commandFactory = new CommandFactory();
        try {
            while (!isInterrupted) {
                while (network.hasPackage()) {
                    NetworkPackage p = network.getPackage();

                    logger.info(String.format(MessageFormatter.getStringFormatByType(p.getType()), p.getMessage()));
                    command = commandFactory.getCommand(currentState, p);
                    command.execute();

                    currentState = stateTransition.nextState(currentState, p);
                    System.out.println(String.format("%1$s: %2$s", p.getType(), currentState.toString()));

                }

                Thread.sleep(TIMEOUT);
            }
        } catch (InterruptedException e) {
            logger.error("Network manager was interrupted unexpectedly");
            throw new NetworkManagerException("Network manager was interrupted unexpectedly", e);
        }
    }

    @Override
    public void stop() {
        logger.info("Stop processing messages.");
        isInterrupted = true;
    }
}
