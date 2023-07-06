package it.sevenbits.courses.testing.practice.core.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

/**
 * Model for an order
 *
 */
public class Order {
    private long id;
    private List<Food> foodList;
    private long price;

    /**
     * The basic constructor
     *
     * @param id - unique identifier from Database
     * @param foodList - order foodList
     * @param price - order price
     */
    @JsonCreator
    public Order(
            @JsonProperty("id") final long id,
            @JsonProperty("foodList") final List<Food> foodList,
            @JsonProperty("price") final long price
    ) {
        this.id = id;
        this.foodList = foodList;
        this.price = price;
    }

    public long getOrderId() {
        return id;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public long getPrice() {
        return price;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order that = (Order) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodList);
    }
}
