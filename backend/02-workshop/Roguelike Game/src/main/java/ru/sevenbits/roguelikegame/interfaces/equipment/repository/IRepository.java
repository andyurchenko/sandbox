package ru.sevenbits.roguelikegame.interfaces.equipment.repository;

public interface IRepository {

    int getMaxSize();
    void setMaxSize(int maxSize);
    int getCurrentSize();
    void setCurrentSize(int currentSize);

    int getValueOfFreeAvailableSpace();

    boolean isOpened();
    boolean isClosed();
    void open();
    void close();
}
