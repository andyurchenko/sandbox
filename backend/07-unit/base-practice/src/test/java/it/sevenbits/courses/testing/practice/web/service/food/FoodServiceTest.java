package it.sevenbits.courses.testing.practice.web.service.food;

import it.sevenbits.courses.testing.practice.core.model.Food;
import it.sevenbits.courses.testing.practice.core.repository.foodrepository.IFoodRepository;
import it.sevenbits.courses.testing.practice.web.model.FoodRequestBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FoodServiceTest {
    private IFoodRepository repositoryMock;
    private IFoodService foodService;

    @BeforeEach
    void tuneUp() {
        repositoryMock = Mockito.mock(IFoodRepository.class);
        foodService = new FoodService(repositoryMock);
    }

    @Test
    void getAllFood() {
        List<Food> foodList = Mockito.mock(List.class);
        Mockito.when(repositoryMock.getAllFood()).thenReturn(foodList);
        List<Food> foodsFromService = foodService.getAllFood();
        assertSame(foodList, foodsFromService);
        Mockito.verify(repositoryMock, Mockito.times(1)).getAllFood();
    }

    @Test
    void getFoodById() {
        Food food_1 = Mockito.mock(Food.class);
        Mockito.when(repositoryMock.getFoodById(1)).thenReturn(food_1);
        assertSame(food_1, foodService.getFoodById(1));
        Mockito.verify(repositoryMock, Mockito.times(1)).getFoodById(1);

        Food defaultFood = new Food(-1, "Unavailable dish", 0);
        Mockito
            .when(repositoryMock.getFoodById(Mockito.longThat(id -> id != 1)))
            .thenReturn(defaultFood);
        assertEquals(defaultFood, foodService.getFoodById(2));
        Mockito.verify(repositoryMock, Mockito.times(1)).getFoodById(2);
    }

    @Test
    void createNewFood() {
        FoodRequestBody foodRequestBody = new FoodRequestBody("newFood", 100);
        Food foodMock = Mockito.mock(Food.class);
        Mockito.when(repositoryMock.addNewFood(Mockito.any(Food.class))).thenReturn(foodMock);

        Food createrFood = foodService.createNewFood(foodRequestBody);
        assertSame(foodMock, createrFood);

        ArgumentCaptor<Food> captor = ArgumentCaptor.forClass(Food.class);
        Mockito.verify(repositoryMock, Mockito.times(1)).addNewFood(captor.capture());
        Food capturedFood = captor.getValue();
        assertEquals("newFood", capturedFood.getName());
        assertEquals(100, capturedFood.getPrice());
        assertTrue(capturedFood.getFoodId() != 1);
    }
}