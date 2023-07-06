package it.sevenbits.courses.sm.manager.network.sm;

import it.sevenbits.courses.sm.network.NetworkPackage;

/**
 * The type State transition.
 */
public final class StateTransition {

    private final StateMap stateMap;

    /**
     * Instantiates a new State transition.
     */
    public StateTransition() {
        this.stateMap = new StateMap();
    }

    /**
     * Next state string.
     *
     * @param state the state
     * @param p     the p
     * @return the string
     */
    public String nextState(final String state, final NetworkPackage p) {
        return stateMap.getNextState(state, p.getType());
    }

    /**
     * Gets start state.
     *
     * @return the start state
     */
    public String getStartState() {
        return this.stateMap.getStartState();
    }
}
