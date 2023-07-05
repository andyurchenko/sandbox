package ru.sevenbits.roguelikegame.interfaces.gamer;

public interface IGamer {
    int getCurrentStrength();
    void setCurrentStrength(int currentStrength);
    int getCurrentAgility();
    void setCurrentAgility(int currentAgility);
    int getCurrentIntelligence();
    void setCurrentIntelligence(int currentIntelligence);
    int getSpeed();
    void setSpeed(int currentSpeed);

    int getCurrentHealth();
    void setCurrentHealth(int currentHealth);
    int getMaxHealth();
    void setMaxHealth(int maxHealth);
}
