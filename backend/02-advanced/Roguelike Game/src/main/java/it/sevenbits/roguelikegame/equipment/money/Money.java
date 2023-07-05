package it.sevenbits.roguelikegame.equipment.money;

/**
 * The type Money.
 */
public class Money implements IMoney {
    private int amount;

    /**
     * Создаем дньги. Жаль, в жизни не так, как в игре.
     *
     * @param amount - размере денег
     */
    public Money(final int amount) {
        this.amount = amount;
    }

    /**
     * Gets amount of money.
     *
     * @return the amount of money
     */
    public int getAmountOfMoney() {
        return amount;
    }

    /**
     * Sets amount of money.
     *
     * @param amountToSet the amount to set
     */
    public void setAmountOfMoney(final int amountToSet) {
        this.amount = amountToSet;
    }

    /**
     * Gets reward.
     *
     * @param luckyBoy      - тот, кому начисляем деньги
     * @param amountOfMoney - сами деньги
     */

}
