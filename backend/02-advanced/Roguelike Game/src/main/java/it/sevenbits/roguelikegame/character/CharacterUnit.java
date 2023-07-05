package it.sevenbits.roguelikegame.character;

import it.sevenbits.roguelikegame.equipment.weapon.Weapon;

/**
 * Общий класс для учавствующий в сражениях.
 */
public abstract class CharacterUnit implements ICharacter {

    private String name;
    private final IParameters parameters;
    private Weapon weapon;

    /**
     * Instantiates a new Fighting unit.
     *
     * @param name       - имя участника сражений
     */
    public CharacterUnit(final String name, final int maxHealth, final int maxStamina, final int strength) {
        this.name = name;
        this.parameters = new Parameters(maxHealth, maxStamina, strength);
    }

    /**
     * Gets weapon.
     *
     * @return the weapon
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * Sets weapon.
     *
     * @param weapon the weapon
     */
    public void setWeapon(final Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public int getCurrentStrength() {
        return this.parameters.getStrength();
    }

    @Override
    public void setCurrentStrength(final int strength) {
        this.parameters.setStrength(strength);
    }

    @Override
    public int getCurrentHealth() {
        return this.parameters.getCurrentHealth();
    }

    @Override
    public void setCurrentHealth(final int currentHealth) {
        this.parameters.setCurrentHealth(currentHealth);
    }

    @Override
    public int getMaxHealth() {
        return this.parameters.getMaxHealth();
    }

    @Override
    public void setMaxHealth(final int maxHealth) {
        this.parameters.setMaxHealth(maxHealth);
    }

    @Override
    public int getCurrentStamina() {
        return this.parameters.getCurrentStamina();
    }

    @Override
    public void setCurrentStamina(final int currentStamina) {
        this.parameters.setCurrentStamina(currentStamina);
    }

    @Override
    public int getMaxStamina() {
        return this.parameters.getMaxStamina();
    }

    @Override
    public void setMaxStamina(final int maxStamina) {
        this.parameters.setMaxStamina(maxStamina);
    }

    @Override
    public int getDamageValue() {
       return this.weapon.getDamageValue();
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String getInfo() {
        return "My name is " + name + "!\n"
                + "\tmy current health is " + this.parameters.getCurrentHealth() + " of " + this.parameters.getMaxHealth() + "\n"
                + "\tmy current stamina is " + this.parameters.getCurrentStamina() + " of " + this.parameters.getMaxStamina() + "\n"
                + "\tmy damage is " + this.weapon.getDamageValue() + "\n";
    }
}
