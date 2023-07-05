package it.sevenbits.courses.testing.practice.core.repository.foodrepository;

import it.sevenbits.courses.testing.practice.core.model.Food;

import java.util.List;

/**
 * Interface for work with food repository
 *
 */
public interface IFoodRepository {

    /**
     * This method returns all existing food products
     * @return list of food products
     */
    List<Food> getAllFood();

    /**
     * Method returns the food by id
     * @param id unique identifier
     * @return instance of the food
     */
    Food getFoodById(long id);

    /**
     * Method add new food in repository
     * @param newFood new Food
     * @return instance of the food
     */
    Food addNewFood(Food newFood);
}
