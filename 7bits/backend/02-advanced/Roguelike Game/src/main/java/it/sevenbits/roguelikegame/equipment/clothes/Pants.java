package it.sevenbits.roguelikegame.equipment.clothes;

import it.sevenbits.roguelikegame.equipment.EquipmentThing;

/**
 * Игровая вещь. Штаны.
 */
public class Pants extends EquipmentThing {
    /**
     * Instantiates a new Pants.
     *
     * @param name   - имя
     * @param size   - размер
     * @param weight - вес
     */
    public Pants(final String name, final  int size, final  int weight) {
        super(name, size, weight);
    }
}
