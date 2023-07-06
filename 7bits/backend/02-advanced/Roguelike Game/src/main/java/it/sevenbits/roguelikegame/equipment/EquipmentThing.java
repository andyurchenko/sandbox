package it.sevenbits.roguelikegame.equipment;

/**
 * Общий класс для любого предмета, который можно хранить в разные хранилищах.
 */
public abstract class EquipmentThing implements IEquipmentThing {
    private String name;
    private int size;
    private int weight;

    /**
     * Instantiates a new Equipment thing.
     *
     * @param name   - название предмета
     * @param size   - размер предмета
     * @param weight - вес предмета
     */
    public EquipmentThing(final String name, final int size, final int weight) {
        this.name = name;
        this.size = size;
        this.weight = weight;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(final int size) {
        this.size = size;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public void setWeight(final int weight) {
        this.weight = weight;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(final String name) {
        this.name = name;
    }
}
