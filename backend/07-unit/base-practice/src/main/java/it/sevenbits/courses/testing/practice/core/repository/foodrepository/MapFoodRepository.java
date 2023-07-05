package it.sevenbits.courses.testing.practice.core.repository.foodrepository;

import it.sevenbits.courses.testing.practice.core.model.Food;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Database foods repository - implementation of foodsRepository
 *
 */
@Repository
public class MapFoodRepository implements IFoodRepository {
    private Map<Long, Food> foodMap;
    private final Food defaultFood = new Food(-1, "Unavailable dish", 0);
    /**
     * The basic constructor
     *
     * @param foodMap instance of a interface for work with database
     */
    public MapFoodRepository(final Map<Long, Food> foodMap) {

        this.foodMap = foodMap;
    }

    @Override
    public List<Food> getAllFood() {
        return new ArrayList<>(this.foodMap.values());
    }

    @Override
    public Food getFoodById(final long id) {
        return this.foodMap.getOrDefault(id, this.defaultFood);
    }

    @Override
    public Food addNewFood(final Food newFood) {
        foodMap.put(newFood.getFoodId(), newFood);
        return foodMap.get(newFood.getFoodId());
    }

}
