package it.sevenbits.roguelikegame.character.monster;

import it.sevenbits.roguelikegame.character.CharacterUnit;

/**
 * The type Monster.
 */
public class Monster extends CharacterUnit {
    /**
     * Instantiates a new Monster.
     *
     * @param name       the name
     */
    public Monster(final String name, final int maxHealth, final int maxStamina, final int strength) {
        super(name, maxHealth, maxStamina, strength);
    }
}
