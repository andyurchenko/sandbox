package it.sevenbits.roguelikegame.character;

/**
 * The interface Fighting unit.
 */
public interface ICharacter {
    /**
     * Gets current strength.
     *
     * @return the current strength
     */
    int getCurrentStrength();

    /**
     * Sets current strength.
     *
     * @param currentStrength the current strength
     */
    void setCurrentStrength(int currentStrength);

    /**
     * Gets current health.
     *
     * @return the current health
     */
    int getCurrentHealth();

    /**
     * Sets current health.
     *
     * @param currentHealth the current health
     */
    void setCurrentHealth(int currentHealth);

    /**
     * Gets max health.
     *
     * @return the max health
     */
    int getMaxHealth();

    /**
     * Sets max health.
     *
     * @param maxHealth the max health
     */
    void setMaxHealth(int maxHealth);

    /**
     * Gets current stamina.
     *
     * @return the current stamina
     */
    int getCurrentStamina();

    /**
     * Sets current stamina.
     *
     * @param currentStamina the current stamina
     */
    void setCurrentStamina(int currentStamina);

    /**
     * Gets max stamina.
     *
     * @return the max stamina
     */
    int getMaxStamina();

    /**
     * Sets max stamina.
     *
     * @param maxStamina the max stamina
     */
    void setMaxStamina(int maxStamina);

    /**
     * Gets damage value.
     *
     * @return the damage value
     */
    int getDamageValue();

    /**
     * Gets info.
     *
     * @return the info
     */
    String getInfo();

    /**
     * Gets name.
     *
     * @return the name
     */
    String getName();
}
