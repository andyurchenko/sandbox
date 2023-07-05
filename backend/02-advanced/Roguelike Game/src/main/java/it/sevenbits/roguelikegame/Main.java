package it.sevenbits.roguelikegame;
import it.sevenbits.roguelikegame.character.monster.Monster;
import it.sevenbits.roguelikegame.equipment.clothes.Pants;
import it.sevenbits.roguelikegame.equipment.money.Money;
import it.sevenbits.roguelikegame.gaming.Game;
import it.sevenbits.roguelikegame.storage.bag.Bag;
import it.sevenbits.roguelikegame.equipment.weapon.bare_hands.BareHands;
import it.sevenbits.roguelikegame.equipment.weapon.claws.Claws;
import it.sevenbits.roguelikegame.equipment.weapon.sword.ShortSword;
import it.sevenbits.roguelikegame.gaming.fighting.Fighting;
import it.sevenbits.roguelikegame.character.hero.Hero;
import it.sevenbits.roguelikegame.gaming.looting.Looting;

/**
 * The type Main.
 */
public final class Main {

    private Main() {
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(final String[] args) {


        Hero shrek = new Hero("Shrek", 100, 25, 5);
        shrek.setWeapon(new BareHands("My mighty hands!", 0, 0, 20));
        Bag bagOfHero = new Bag(100);
        shrek.setBag(bagOfHero);

        Monster princeCharming = new Monster("Prince Charming", 65, 50, 1);
        princeCharming.setWeapon(new ShortSword("Good short sword", 5, 5, 10));

        Pants goodPants = new Pants("Good pants", 5, 1);
        Game.getThingInto(shrek.getBag(), goodPants);
        System.out.println("Shrek: I've found a very good pants and placed it in my bag!");

        Game.fight(shrek, princeCharming);
        Game.rewardHero(shrek, 42);
        System.out.println("Shrek: Wow! Some gold here to take after battle!");

        Pants tShirt = new Pants("Some TShirt", 8, 2);
        Game.getThingInto(shrek.getBag(), tShirt);
        System.out.println("Shrek:  Look at this t-shirt! Gonna take it with me!");

        Monster dragon = new Monster("Black Scary Dragon", 300, 50, 5);
        dragon.setWeapon(new Claws("Big sharp claws", 0, 0, 30));
        Game.fight(shrek, dragon);
    }

}
