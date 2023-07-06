package it.sevenbits.roguelikegame.character.hero;

import it.sevenbits.roguelikegame.character.CharacterUnit;
import it.sevenbits.roguelikegame.equipment.money.IMoney;
import it.sevenbits.roguelikegame.equipment.money.Money;
import it.sevenbits.roguelikegame.storage.bag.Bag;

/**
 * Класс для героя
 */
public class Hero extends CharacterUnit implements IRewardingHero {

    private final IMoney money;
    private Bag bag;

    /**
     * Instantiates a new Hero.
     *
     * @param name       - имя героя
     */
    public Hero(final String name, final int maxHealth, final int maxStamina, final int strength) {
        super(name, maxHealth, maxStamina, strength);
        this.money = new Money(0);
    }

    private IMoney getMoney() {
        return this.money;
    }

    /**
     * Gets bag.
     *
     * @return the bag
     */
    public Bag getBag() {
        return bag;
    }

    /**
     * Sets bag.
     *
     * @param bag the bag
     */
    public void setBag(final Bag bag) {
        this.bag = bag;
    }

    private void setAmountOfMoney(int amountOfMoney) {
       this.money.setAmountOfMoney(
            this.getAmountOfMoney() + amountOfMoney
       );
    }

    private int getAmountOfMoney() {
        return this.money.getAmountOfMoney();
    }

    @Override
    public String getInfo() {


        return "My name is " + this.getName() + "!\n"
                + "\tmy current health is " + this.getCurrentHealth() + " of " + this.getMaxHealth() + "\n"
                + "\tmy current stamina is " + this.getCurrentStamina() + " of " + this.getMaxStamina() + "\n"
                + "\tmy damage is " + this.getWeapon().getDamageValue() + "\n"
                + "\tamount of money is " + this.getAmountOfMoney() + "\n"
                + "\tin my bag there are: " + this.getBag().toString();
    }


    @Override
    public void rewardHero(int amountOfMoney) {
        this.setAmountOfMoney(amountOfMoney);
    }
}
