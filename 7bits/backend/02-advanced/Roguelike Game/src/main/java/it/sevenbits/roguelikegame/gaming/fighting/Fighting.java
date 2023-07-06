package it.sevenbits.roguelikegame.gaming.fighting;

import it.sevenbits.roguelikegame.character.ICharacter;

/**
 * Класс со статическими функциями для проведения боевки
 */
public final class Fighting {
    private static final int COEFFICIENT_FOR_STAMINA_CALC = 2;

    private Fighting() {
    }

    /**
     * Lets get ready to rumble.
     *
     * @param hero    - герой, который будет побеждать злодея
     * @param monster - злодей, который будет обязательно побежден героем
     */
    public static void letsGetReadyToRumble(final ICharacter hero, final ICharacter monster) {
        System.out.println("!!! The fight has started !!!");
        while (isAbleToFight(hero) && isAbleToFight(monster)) {
            exchangeStrikes(hero, monster);
            restBeforeStrikes(hero);
            restBeforeStrikes(monster);
        }
        System.out.println("!!! The fight has ended !!!");
        System.out.println("Our winner is " + getTheWinnerName(hero, monster) + "!");
        System.out.println("Results of fight:");
        System.out.println(hero.getInfo());
        System.out.println(monster.getInfo());
    }

    private static boolean isAbleToFight(final ICharacter fighter) {
        return fighter.getCurrentHealth() > 0;
    }

    private static void exchangeStrikes(final ICharacter hero, final ICharacter monster) {
        if (isEnoughStaminaToStrike(hero)) {
            System.out.println(hero.getName() + ": I've enough strength(" + hero.getCurrentStamina() + ") to strike you, " + monster.getName() + "!");
            calcCurrentStaminaAfterStriking(hero);
            calcCurrentHealthAfterTakingDamage(monster, hero.getDamageValue());
            System.out.println("\t" + monster.getName() + ": Ouch! I have " + monster.getCurrentHealth() + " health left!");
            if (!isAbleToFight(hero)) {
                System.out.println(hero.getName() + ": I cannot fight anymore! I'm dying!");
            }
        } else {
            System.out.println(hero.getName() + ": I cannot strike! I need some rest!");
        }
        if (isAbleToFight(monster)) {
            if (isEnoughStaminaToStrike(monster)) {
                System.out.println(monster.getName() + ": I've enough strength(" + monster.getCurrentStamina() + ") to strike you, " + hero.getName() + "!");
                calcCurrentStaminaAfterStriking(monster);
                calcCurrentHealthAfterTakingDamage(hero, monster.getDamageValue());
                System.out.println("\t" + hero.getName() + ": Ouch! I have " + hero.getCurrentHealth() + " health left!");
            } else {
                System.out.println(monster.getName() + ": I cannot strike! I need some rest!");
            }

        } else {
            System.out.println(monster.getName() + ": I cannot fight anymore! I'm dying!");
        }
    }

    private static boolean isEnoughStaminaToStrike(final ICharacter fighter) {
        return fighter.getCurrentStamina() > (fighter.getDamageValue() / COEFFICIENT_FOR_STAMINA_CALC);
    }

    private static void calcCurrentHealthAfterTakingDamage(final ICharacter fighter, final int damage) {
        int currentHealthAfterDamage = fighter.getCurrentHealth() - (damage);
        fighter.setCurrentHealth(Math.max(currentHealthAfterDamage, 0));
    }

    private static void calcCurrentStaminaAfterStriking(final ICharacter fighter) {
        fighter.setCurrentStamina(
                Math.min(
                        (fighter.getCurrentStamina() - (fighter.getDamageValue() / COEFFICIENT_FOR_STAMINA_CALC))
                        , fighter.getMaxStamina()));
    }

    private static void restBeforeStrikes(final ICharacter fighter) {
        fighter.setCurrentStamina(Math.min(
                (fighter.getCurrentStamina() + fighter.getCurrentStrength())
                , fighter.getMaxStamina()));
    }

    private static String getTheWinnerName(final ICharacter hero, final ICharacter monster) {
        if (isAbleToFight(hero)) {
            return hero.getName();
        } else {
            return monster.getName();
        }
    }


}
