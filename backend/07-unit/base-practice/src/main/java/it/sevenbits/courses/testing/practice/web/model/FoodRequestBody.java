package it.sevenbits.courses.testing.practice.web.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model class to describe food for request.
 */
public class FoodRequestBody {

    private long price;

    private String name;

    /**
     * The basic constructor
     *
     * @param name - name of Food
     * @param price - price of Food
     */
    @JsonCreator
    public FoodRequestBody(
            @JsonProperty("name") final String name,
            @JsonProperty("price") final long price
    ) {
        this.name = name;
        this.price = price;
    }

    public long getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }


}
