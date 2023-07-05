package it.sevenbits.courses.testing.practice.web.controller;

import it.sevenbits.courses.testing.practice.core.model.Food;
import it.sevenbits.courses.testing.practice.web.model.FoodRequestBody;
import it.sevenbits.courses.testing.practice.web.service.food.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Controller for the food endpoint
 *
 */
@Controller
@RequestMapping("/food")
public class FoodController {
    private final IFoodService foodService;

    /**
     * Basic constructor
     * @param foodService food service
     */
    @Autowired
    public FoodController(final IFoodService foodService) {
        this.foodService = foodService;
    }

    /**
     * This method returns all existing orders
     * @return response entity with list of Order objects
     */
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Food>> getAllFood() {
        try {
            List<Food> foodList = foodService.getAllFood();
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(foodList);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Method creates new Food
     * @param requestBody request model with required parameter for creation
     * @return response entity with order
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<Food> getNewFood(final @RequestBody FoodRequestBody requestBody) {
        try {
            Food food = foodService.createNewFood(requestBody);
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(food);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
