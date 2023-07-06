package it.sevenbits.roguelikegame.gaming;

import it.sevenbits.roguelikegame.character.ICharacter;
import it.sevenbits.roguelikegame.character.hero.IRewardingHero;
import it.sevenbits.roguelikegame.equipment.IEquipmentThing;
import it.sevenbits.roguelikegame.gaming.fighting.Fighting;
import it.sevenbits.roguelikegame.gaming.looting.Looting;
import it.sevenbits.roguelikegame.gaming.rewarding.Rewarding;
import it.sevenbits.roguelikegame.storage.IStorage;

public class Game {
    public static void fight(final ICharacter hero, final ICharacter monster) {
        Fighting.letsGetReadyToRumble(hero, monster);
    }

    public static void getThingInto(final IStorage whereToPut, final IEquipmentThing whatToPut) {
        Looting.getThingInto(whereToPut, whatToPut);
    }

    public static void rewardHero(final IRewardingHero luckyBoy, final int amountOfMoney) {
        Rewarding.rewardHero(luckyBoy, amountOfMoney);
    }
}
