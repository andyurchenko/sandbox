package it.sevenbits.courses.sm.log;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Message formatter.
 */
public final class MessageFormatter {
    private MessageFormatter() {
    }

    private static final Map<String, String> messages;
    static {
        messages = new HashMap<>();
        messages.put("MESSAGE", "Part of message: %1$s");
        messages.put("TRASH", "Trash received");
        messages.put("MESSAGE_START", "Message creating started");
        messages.put("MESSAGE_FINISH", "Message creating finished");
    }

    /**
     * Gets string format by type.
     *
     * @param type the type
     * @return the string format by type
     */
    public static String getStringFormatByType(final String type) {
        return messages.getOrDefault(type, "Unknown package type");
    }
}
