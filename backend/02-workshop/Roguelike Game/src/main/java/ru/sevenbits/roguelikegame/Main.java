package ru.sevenbits.roguelikegame;

import ru.sevenbits.roguelikegame.Enums.RepositoryState;
import ru.sevenbits.roguelikegame.Implementations.equipment.repository.chest.Chest;
import ru.sevenbits.roguelikegame.Implementations.equipment.weapon.sword.ShortSword;
import ru.sevenbits.roguelikegame.interfaces.equipment.inventory.IInventory;
import ru.sevenbits.roguelikegame.interfaces.equipment.repository.IRepository;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Main {
    /**
     *
     * @param args
     */
    public static void main(final String[] args) {
        Chest chest = new Chest(100, RepositoryState.CLOSED);
        List<ShortSword> swords = new ArrayList<>();
        swords.add(new ShortSword(1, 2, 3, 4));
        swords.add(new ShortSword(10, 20, 30, 40));
        swords.add(new ShortSword(100, 200, 300, 400));
        chest.open();
        for (ShortSword sword : swords) {
            putSwordIn(chest, sword);
        }
        chest.close();


    }

    /**
     *
     * Just for testing
     * @param repository
     * @param inventory
     */
    public static void putSwordIn(final IRepository repository, final IInventory inventory) {
        if (repository.isOpened()) {
            System.out.println("Какой замечательный меч! Положу его к себе, если влезет!");
            if (repository.getValueOfFreeAvailableSpace() >= inventory.getSize()) {
                System.out.println("Замечательно, место нашлось!");
            }

        }
    }
}
