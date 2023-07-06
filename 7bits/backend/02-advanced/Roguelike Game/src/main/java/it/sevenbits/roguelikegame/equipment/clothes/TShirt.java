package it.sevenbits.roguelikegame.equipment.clothes;

import it.sevenbits.roguelikegame.equipment.EquipmentThing;

/**
 * Игровая вещь. Футболка.
 */
public class TShirt extends EquipmentThing {
    /**
     * Instantiates a new T shirt.
     *
     * @param name   - имя
     * @param size   - размер
     * @param weight - вес
     */
    public TShirt(final String name, final int size, final int weight) {
        super(name, size, weight);
    }
}
