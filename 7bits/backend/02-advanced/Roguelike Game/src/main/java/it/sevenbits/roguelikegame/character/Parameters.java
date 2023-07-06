package it.sevenbits.roguelikegame.character;

/**
 * Класс для параметров персонажей игры
 */
class Parameters implements IParameters {
    private int currentHealth;
    private int maxHealth;
    private int currentStamina;
    private int maxStamina;
    private int strength;

    /**
     * Instantiates a new Parameters.
     *
     * @param maxHealth  - максимальный уровень жизни
     * @param maxStamina - максимальный уровень выносливости
     * @param strength   - сила персонажа
     */
    Parameters(final int maxHealth, final int maxStamina, final int strength) {
        this.currentHealth = maxHealth;
        this.maxHealth = maxHealth;
        this.currentStamina = maxStamina;
        this.maxStamina = maxStamina;
        this.strength = strength;
    }

    /**
     * Gets current health.
     *
     * @return the current health
     */
    public int getCurrentHealth() {
        return currentHealth;
    }

    /**
     * Sets current health.
     *
     * @param currentHealth the current health
     */
    public void setCurrentHealth(final int currentHealth) {
        this.currentHealth = currentHealth;
    }

    /**
     * Gets max health.
     *
     * @return the max health
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * Sets max health.
     *
     * @param maxHealth the max health
     */
    public void setMaxHealth(final int maxHealth) {
        this.maxHealth = maxHealth;
    }

    /**
     * Gets current stamina.
     *
     * @return the current stamina
     */
    public int getCurrentStamina() {
        return currentStamina;
    }

    /**
     * Sets current stamina.
     *
     * @param currentStamina the current stamina
     */
    public void setCurrentStamina(final int currentStamina) {
        this.currentStamina = currentStamina;
    }

    /**
     * Gets max stamina.
     *
     * @return the max stamina
     */
    public int getMaxStamina() {
        return maxStamina;
    }

    /**
     * Sets max stamina.
     *
     * @param maxStamina the max stamina
     */
    public void setMaxStamina(final int maxStamina) {
        this.maxStamina = maxStamina;
    }

    /**
     * Gets strength.
     *
     * @return the strength
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Sets strength.
     *
     * @param strength the strength
     */
    public void setStrength(final int strength) {
        this.strength = strength;
    }
}
