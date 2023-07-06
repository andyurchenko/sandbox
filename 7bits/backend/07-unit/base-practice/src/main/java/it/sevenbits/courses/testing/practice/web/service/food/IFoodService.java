package it.sevenbits.courses.testing.practice.web.service.food;

import it.sevenbits.courses.testing.practice.core.model.Food;
import it.sevenbits.courses.testing.practice.web.model.FoodRequestBody;


import java.util.List;

/**
 * Interface for service which works with food
 */
public interface IFoodService {

    /**
     * This method returns all existing food products
     * @return list of food
     */
    List<Food> getAllFood();

    /**
     * Method returns the food by id
     * @param id unique identifier
     * @return instance of the food
     */
    Food getFoodById(long id);


    /**
     * Method add new food
     * @param foodRequestBody request model with required parameters
     * @return instance of the food
     */
    Food createNewFood(FoodRequestBody foodRequestBody);

}
