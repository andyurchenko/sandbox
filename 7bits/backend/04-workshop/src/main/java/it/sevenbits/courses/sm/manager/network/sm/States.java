package it.sevenbits.courses.sm.manager.network.sm;

public  final class States {
    public static final State listenState = new State("LISTEN");
    public static final State stubSuspicion = new State("TRASH_SUSPICION");
    public static final State defaultState = new State("IGNORE");
}
