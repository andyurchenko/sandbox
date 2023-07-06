package it.sevenbits.courses.sm;

import it.sevenbits.courses.sm.manager.network.INetworkManager;
import it.sevenbits.courses.sm.network.INetwork;

import java.util.Random;

/**
 * The type Packages generator.
 */
public class PackagesGenerator {
    private final String[] messages = {
            " First message ", " Second message ", " Third message ", " Fourth message ", " Fifth message  "
    };
//    private String trash = "************";
//    private String senselessMsg = "##(!@)";
    private String trash = "***trash***";
    private String senselessMsg = "*start*stop*";

    private final long DEFAULT_TIMEOUT = 10;
    private final int DEFAULT_ITERATIONS_COUNT = 500;

    /**
     * Packages filler task one thread.
     *
     * @param nm      the nm
     * @param network the network
     * @return the thread
     */
    public Thread packagesFillerTaskOne(final INetworkManager nm, final INetwork network) {
        return new Thread(() -> {
            System.out.println("[Task one] packages generator started");
            int count = 0;
            Random rand = new Random();
            while (count < DEFAULT_ITERATIONS_COUNT) {
                count++;
                boolean isStub = rand.nextBoolean();
                if (!isStub) {
                    network.addPackage(messages[count % messages.length], "MESSAGE");
                    continue;
                }

                network.addPackage(trash, "TRASH");
                try {
                    Thread.sleep(DEFAULT_TIMEOUT);
                } catch (InterruptedException e) {
                    break;
                }
            }
            nm.stop();
        });
    }

    /**
     * Packages filler task two thread.
     *
     * @param nm      the nm
     * @param network the network
     * @return the thread
     */
    public Thread packagesFillerTaskTwo(final INetworkManager nm, final INetwork network) {
        return new Thread(() -> {
            System.out.println("[Task two] packages generator started");
            int count = 0;
            Random rand = new Random();
            while (count < DEFAULT_ITERATIONS_COUNT) {
                count++;
                boolean isMessage = rand.nextBoolean();
                if (isMessage) {
                    network.addPackage(senselessMsg, "MESSAGE_START");
                    int index = count % messages.length;
                    for (int i = 0; i <= index; i++) {
                        network.addPackage(messages[index], "MESSAGE");
                    }

                    index = (index - 1) % messages.length - 1;
                    for (int i = 0; i < index; i++) {
                        network.addPackage(trash, "TRASH");
                    }
                    network.addPackage(senselessMsg, "MESSAGE_FINISH");
                    continue;
                }

                network.addPackage(trash, "TRASH");
                try {
                    Thread.sleep(DEFAULT_TIMEOUT);
                } catch (InterruptedException e) {
                    break;
                }
            }
            nm.stop();
        });
    }
}
