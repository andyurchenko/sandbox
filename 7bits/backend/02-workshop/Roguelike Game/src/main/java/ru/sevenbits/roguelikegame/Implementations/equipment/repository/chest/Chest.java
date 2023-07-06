package ru.sevenbits.roguelikegame.Implementations.equipment.repository.chest;

import ru.sevenbits.roguelikegame.Enums.RepositoryState;
import ru.sevenbits.roguelikegame.interfaces.equipment.repository.IRepository;

/**
 *
 */
public class Chest implements IRepository {

    private int maxSize;
    private int currentSize;
    private RepositoryState chestState;

    /**
     * Class for chests in the game/
     * @param maxSize
     * @param chestState
     */
    public Chest(int maxSize, RepositoryState chestState) {
        this.maxSize = maxSize;
        this.chestState = chestState;
    }

    @Override
    public int getMaxSize() {
        return this.maxSize;
    }

    @Override
    public void setMaxSize(final int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public int getCurrentSize() {
        return this.currentSize;
    }

    @Override
    public void setCurrentSize(final int currentSize) {
        this.currentSize = currentSize;
    }

    @Override
    public int getValueOfFreeAvailableSpace() {
        return this.getMaxSize() - this.getCurrentSize();
    }

    @Override
    public boolean isOpened() {
        return chestState == RepositoryState.OPENED;
    }

    @Override
    public boolean isClosed() {
        return chestState == RepositoryState.CLOSED;
    }

    @Override
    public void open() {
        System.out.println("Открыть сундук!");
        chestState = RepositoryState.OPENED;
    }

    @Override
    public void close() {
        System.out.println("Закрыть сундук!");
        chestState = RepositoryState.CLOSED;
    }
}
