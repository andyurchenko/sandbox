package it.sevenbits.roguelikegame.gaming.looting;

import it.sevenbits.roguelikegame.equipment.IEquipmentThing;
import it.sevenbits.roguelikegame.storage.IStorage;

/**
 * Класс со статичискими методами для работы с хранилищами.
 */
public final class Looting {
    private Looting() {
    }

    /**
     * Gets thing into.
     *
     * @param whereToPut - хранилиже, куда положить предмет
     * @param whatToPut  - предмет, который будет положен в хранилище
     */
    public static void getThingInto(final IStorage whereToPut, final IEquipmentThing whatToPut) {
        if (isEnoughSpaceToPutThingInto(whereToPut, whatToPut)) {
            whereToPut.putThingInto(whatToPut);
        }
    }

    private static boolean isEnoughSpaceToPutThingInto(final IStorage whereToPut, final IEquipmentThing whatToPut) {
        return whereToPut.getValueOfFreeAvailableSpace() >= whatToPut.getSize();
    }
}
