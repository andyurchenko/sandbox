package it.sevenbits.courses.testing.practice.web.service.food;

import it.sevenbits.courses.testing.practice.core.model.Food;
import it.sevenbits.courses.testing.practice.core.repository.foodrepository.IFoodRepository;

import it.sevenbits.courses.testing.practice.web.model.FoodRequestBody;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This is service for a book entity
 */

@Service
public class FoodService implements IFoodService {
    private IFoodRepository foodRepository;

    private long idCounter = 0;

    /**
     * The basic constructor
     *
     * @param foodRepository - food repository
     */
    public FoodService(final IFoodRepository foodRepository) {

        this.foodRepository = foodRepository;
    }

    @Override
    public List<Food> getAllFood() {
        return foodRepository.getAllFood();
    }

    @Override
    public Food getFoodById(final long id) {
        return foodRepository.getFoodById(id);
    }

    @Override
    public Food createNewFood(final FoodRequestBody foodRequestBody) {
        long id = generateNewId();
        Food newFood = new Food(id, foodRequestBody.getName(), foodRequestBody.getPrice());
        return foodRepository.addNewFood(newFood);
    }

    private long generateNewId() {
        long result = idCounter;
        idCounter += 1;
        return result;
    }
}
