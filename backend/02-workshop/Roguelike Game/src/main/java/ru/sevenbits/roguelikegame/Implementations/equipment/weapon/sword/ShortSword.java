package ru.sevenbits.roguelikegame.Implementations.equipment.weapon.sword;

import ru.sevenbits.roguelikegame.interfaces.equipment.inventory.IInventory;
import ru.sevenbits.roguelikegame.interfaces.equipment.weapon.IWeapon;

/**
 * Example of weapon.
 */
public class ShortSword implements IInventory, IWeapon {

    private int size;
    private int weight;
    private int attackSpeed;
    private int damage;

    /**
     * Create a weapon
     * @param size
     * @param weight
     * @param attackSpeed
     * @param damage
     */
    public ShortSword(final int size, final int weight, final int attackSpeed, final int damage) {
        this.size = size;
        this.weight = weight;
        this.attackSpeed = attackSpeed;
        this.damage = damage;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int getAttackSpeedValue() {
        return this.attackSpeed;
    }

    @Override
    public void setAttackSpeedValue(int attackSpeedValue) {
        this.attackSpeed = attackSpeedValue;
    }

    @Override
    public int getDamageValue() {
        return this.damage;
    }

    @Override
    public void setDamageValue(int damageValue) {
        this.damage = damageValue;
    }
}
