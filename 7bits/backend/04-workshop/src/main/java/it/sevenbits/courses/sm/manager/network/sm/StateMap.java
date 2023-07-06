package it.sevenbits.courses.sm.manager.network.sm;

import it.sevenbits.courses.sm.network.NetworkPackageType;

import java.util.HashMap;
import java.util.Map;

/**
 * The type State map.
 */
class StateMap {
//    private final State defaultState = new State("IGNORE");

    private final Map<Pair<String, String>, String> states;

    /**
     * Instantiates a new State map.
     */
    StateMap() {
        states = new HashMap<>();
//        State listenState = new State("LISTEN");
//        State stubSuspicion = new State("TRASH_SUSPICION");

        states.put(new Pair<>(NetworkState.NEW_SESSION, NetworkPackageType.MESSAGE), NetworkState.NEW_SESSION);
        states.put(new Pair<>(NetworkState.NEW_SESSION, NetworkPackageType.TRASH), NetworkState.NEW_SESSION);
        states.put(new Pair<>(NetworkState.NEW_SESSION, NetworkPackageType.MESSAGE_START), NetworkState.LISTEN);
        states.put(new Pair<>(NetworkState.NEW_SESSION, NetworkPackageType.MESSAGE_FINISH), NetworkState.NEW_SESSION);


        states.put(new Pair<>(NetworkState.LISTEN, NetworkPackageType.MESSAGE), NetworkState.LISTEN);
        states.put(new Pair<>(NetworkState.LISTEN, NetworkPackageType.TRASH), NetworkState.TRASH_SUSPICION);
        states.put(new Pair<>(NetworkState.LISTEN, NetworkPackageType.MESSAGE_START), NetworkState.TRASH_SUSPICION);
        states.put(new Pair<>(NetworkState.LISTEN, NetworkPackageType.MESSAGE_FINISH), NetworkState.NEW_SESSION);

        states.put(new Pair<>(NetworkState.TRASH_SUSPICION, NetworkPackageType.MESSAGE), NetworkState.TRASH_SUSPICION);
        states.put(new Pair<>(NetworkState.TRASH_SUSPICION, NetworkPackageType.TRASH), NetworkState.NEW_SESSION);
        states.put(new Pair<>(NetworkState.TRASH_SUSPICION, NetworkPackageType.MESSAGE_START), NetworkState.NEW_SESSION);
        states.put(new Pair<>(NetworkState.TRASH_SUSPICION, NetworkPackageType.MESSAGE_FINISH), NetworkState.NEW_SESSION);
    }

    /**
     * Gets start state.
     *
     * @return the start state
     */
    public String getStartState() {
        return NetworkState.NEW_SESSION;
    }

    /**
     * Gets next state.
     *
     * @param state  the state
     * @param signal the signal
     * @return the next state
     */
    public String getNextState(final String state, final String signal) {
        return states.getOrDefault(new Pair<>(state, signal), NetworkState.NEW_SESSION);
    }
}
