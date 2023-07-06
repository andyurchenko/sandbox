package ru.sevenbits.roguelikegame.interfaces.monster;

public interface IMonster {
    int getAttackSpeedValue();
    void setAttackSpeedValue(int attackSpeedValue);

    int getDamageValue();
    void setDamageValue(int damageValue);

    int getDefenseValue();
    void setDefenseValue(int defenseValue);

    int getSpeed();
    void setSpeed(int speed);

    int getCurrentHealth();
    void setCurrentHealth(int currentHealth);
    int getMaxHealth();
    void setMaxHealth(int maxHealth);
}
