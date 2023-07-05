package it.sevenbits.courses.sm;

import it.sevenbits.courses.sm.manager.network.INetworkManager;
import it.sevenbits.courses.sm.manager.network.sm.StateMachineNetworkManager;
import it.sevenbits.courses.sm.network.INetwork;
import it.sevenbits.courses.sm.network.Network;

/**
 * The type Main.
 */
public final class Main {

    private Main() {
    }

    /**
     * Main.
     *
     * @param args the args
     * @throws Exception the exception
     */
    public static void main(final String[] args) throws Exception {
//        final INetworkManager nm = new SimpleNetworkManager();
        final INetworkManager nm = new StateMachineNetworkManager();
        final INetwork network = new Network(500);

        PackagesGenerator packagesGenerator = new PackagesGenerator();
//        Thread createMessagesThread = packagesGenerator.packagesFillerTaskOne(nm, network);
        Thread createMessagesThread = packagesGenerator.packagesFillerTaskTwo(nm, network);
        createMessagesThread.start();
//        createMessagesThread.join();
        nm.listen(network);
    }
}
