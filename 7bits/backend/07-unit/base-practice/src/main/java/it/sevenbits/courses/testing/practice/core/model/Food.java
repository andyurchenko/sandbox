package it.sevenbits.courses.testing.practice.core.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Model for a food
 *
 */
public class Food {
    private long id;
    private String name;
    private long price;

    /**
     * The basic constructor
     *
     * @param id - unique identifier from Database
     * @param name - food name
     * @param price - food price
     */
    @JsonCreator
    public Food(
            @JsonProperty("id") final long id,
            @JsonProperty("name") final String name,
            @JsonProperty("price") final long price
    ) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getFoodId() {
        return id;
    }

    public String getName() {
        return name;
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
        Food that = (Food) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
