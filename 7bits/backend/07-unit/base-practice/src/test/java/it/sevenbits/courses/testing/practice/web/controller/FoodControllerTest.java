package it.sevenbits.courses.testing.practice.web.controller;

import it.sevenbits.courses.testing.practice.web.model.FoodRequestBody;
import it.sevenbits.courses.testing.practice.web.service.food.FoodService;
import it.sevenbits.courses.testing.practice.core.model.Food;
import it.sevenbits.courses.testing.practice.web.service.food.IFoodService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

class FoodControllerTest {
    private IFoodService foodServiceMock;
    private FoodController foodController;

    @BeforeEach
    void tuneUp() {
        foodServiceMock = Mockito.mock(FoodService.class);
        foodController = new FoodController(foodServiceMock);
    }

    @Test
    void getAllFood() {
        List<Food> foodListMock = Mockito.mock(List.class);
        Mockito.when(foodServiceMock.getAllFood()).thenReturn(foodListMock);

        ResponseEntity<List<Food>> response = foodController.getAllFood();
        Mockito.verify(foodServiceMock, Mockito.times(1)).getAllFood();
        Assertions.assertSame(foodListMock, response.getBody());
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getNewFood() {
        FoodRequestBody requestBodyMock = Mockito.mock(FoodRequestBody.class);
        Food foodMock = Mockito.mock(Food.class);
        Mockito.when(foodServiceMock.createNewFood(Mockito.any(FoodRequestBody.class))).thenReturn(foodMock);

        ResponseEntity<Food> response = foodController.getNewFood(requestBodyMock);
        Assertions.assertSame(foodMock, response.getBody());
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}