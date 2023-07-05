/**
 * Info
 */
package it.sevenbits.roguelikegame.storage.bag;

import it.sevenbits.roguelikegame.equipment.IEquipmentThing;
import it.sevenbits.roguelikegame.storage.GenericStorage;

import java.util.HashMap;
import java.util.Map;

/**
 * Сумка для главного героя, где он будет носить свои важные вещи.
 */
public class Bag extends GenericStorage {

    private final HashMap<String, IEquipmentThing> thingsInBag;

    /**
     * Instantiates a new Bag.
     *
     * @param maxSize - максимальный размер сумки
     */
    public Bag(final int maxSize) {
        super(maxSize);
        thingsInBag = new HashMap<>();
    }

    @Override
    public void putThingInto(final IEquipmentThing thingToPut) {
        this.thingsInBag.put(thingToPut.getName(), thingToPut);
    }

    @Override
    public IEquipmentThing getThingFrom(final String name) {
        if (this.thingsInBag.containsKey(name)) {
            IEquipmentThing thing = thingsInBag.get(name);
            this.thingsInBag.remove(name);
            return thing;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, IEquipmentThing> thing : thingsInBag.entrySet()) {
            sb.append(thing.getKey());
            sb.append(" ");
        }
        return sb.toString();
    }
}
