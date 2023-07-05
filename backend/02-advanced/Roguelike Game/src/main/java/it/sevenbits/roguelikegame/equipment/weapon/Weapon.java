package it.sevenbits.roguelikegame.equipment.weapon;

import it.sevenbits.roguelikegame.equipment.EquipmentThing;

/**
 * The type Weapon.
 */
public abstract class Weapon extends EquipmentThing implements IWeapon {
    private int damage;

    /**
     * Instantiates a new Weapon.
     *
     * @param name   the name
     * @param size   the size
     * @param weight the weight
     * @param damage the damage
     */
    public Weapon(final String name, final int size, final int weight, final int damage) {
        super(name, size, weight);
        this.setDamageValue(damage);
    }


    /**
     * Gets damage value.
     *
     * @return the damage value
     */
    @Override
    public int getDamageValue() {
        return this.damage;
    }

    private void setDamageValue(final int damageValue) {
        this.damage = damageValue;
    }
}
