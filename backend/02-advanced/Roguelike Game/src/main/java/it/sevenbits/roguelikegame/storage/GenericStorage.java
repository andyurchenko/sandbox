package it.sevenbits.roguelikegame.storage;

import it.sevenbits.roguelikegame.storage.enums.StorageState;

/**
 * Общий класс для любого хранилища типа сумки, сундунка и тд.
 */
public abstract class GenericStorage implements IStorage {
    private int maxSize;
    private int usedSpace;
    private StorageState storageState;

    /**
     * Instantiates a new Generic storage.
     *
     * @param maxSize - максимальный размер хранилища
     */
    public GenericStorage(final int maxSize) {
        this.maxSize = maxSize;
        this.storageState = StorageState.CLOSED;
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
    public int getValueOfFreeAvailableSpace() {
        return this.getMaxSize() - this.getUsedSpace();
    }

    @Override
    public boolean isOpened() {
        return storageState == StorageState.OPENED;
    }

    @Override
    public boolean isClosed() {
        return storageState == StorageState.CLOSED;
    }

    @Override
    public void open() {
        storageState = StorageState.OPENED;
    }

    @Override
    public void close() {
        storageState = StorageState.CLOSED;
    }

    private int getUsedSpace() {
        return usedSpace;
    }

    private void setUsedSpace(final int usedSpace) {
        this.usedSpace = usedSpace;
    }



}

