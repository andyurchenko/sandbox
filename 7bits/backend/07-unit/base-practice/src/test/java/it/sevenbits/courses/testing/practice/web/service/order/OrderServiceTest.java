package it.sevenbits.courses.testing.practice.web.service.order;

import it.sevenbits.courses.testing.practice.core.model.Food;
import it.sevenbits.courses.testing.practice.core.model.Order;
import it.sevenbits.courses.testing.practice.core.repository.foodrepository.IFoodRepository;
import it.sevenbits.courses.testing.practice.core.repository.orderrepository.IOrderRepository;
import it.sevenbits.courses.testing.practice.web.model.OrderRequestBody;
import it.sevenbits.courses.testing.practice.web.service.food.IFoodService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

class OrderServiceTest {
    private IOrderRepository orderRepository;
    private IFoodService foodService;
    private IOrderService orderService;
//    private IOrderService orderServiceSpy;

    @BeforeEach
    void setup() {
        orderRepository = Mockito.mock(IOrderRepository.class);
        foodService = Mockito.mock(IFoodService.class);
        orderService = new OrderService(orderRepository, foodService);
//        orderServiceSpy = Mockito.spy(orderService);
    }

    @Test
    void getAllOrders() {
        List<Order> orderList = Mockito.mock(List.class);
        Mockito.when(orderRepository.getAllOrders()).thenReturn(orderList);
        Assertions.assertSame(orderList, orderService.getAllOrders());
        Mockito.verify(orderRepository, Mockito.times(1)).getAllOrders();
    }

    @Test
    void getOrderById() {
        Order defaultOrder = new Order(-1, new ArrayList<>(), 0);
        Order order = new Order(1, new ArrayList<>(), 100);
        Mockito.when(orderRepository.getOrderById(1)).thenReturn(order);
        Assertions.assertSame(order, orderService.getOrderById(1));
        Mockito.verify(orderRepository, Mockito.times(1)).getOrderById(1);

        Mockito.when(orderRepository.getOrderById(2)).thenReturn(defaultOrder);
        Assertions.assertSame(defaultOrder, orderService.getOrderById(2));
        Mockito.verify(orderRepository, Mockito.times(1)).getOrderById(2);
    }

    @Test
    void createNewOrder() {
        List<Long> foodIdList = new ArrayList<>();
        foodIdList.add(1L);
        foodIdList.add(2L);
        foodIdList.add(3L);
        OrderRequestBody requestBody = new OrderRequestBody(foodIdList);

        Food food_1 = new Food(1L, "food_1", 1);
        Mockito.when(foodService.getFoodById(1L)).thenReturn(food_1);
        Food food_2 = new Food(2L, "food_2", 2);
        Mockito.when(foodService.getFoodById(2L)).thenReturn(food_2);
        Food food_3 = new Food(3L, "food_3", 3);
        Mockito.when(foodService.getFoodById(3L)).thenReturn(food_3);
        List<Food> foodList = new ArrayList<>();
        foodList.add(food_1);
        foodList.add(food_2);
        foodList.add(food_3);

        Order order = Mockito.mock(Order.class);
        Mockito.when(orderRepository.addOrder(Mockito.any(Order.class))).thenReturn(order);

        Order orderFromService = orderService.createNewOrder(requestBody);
        Mockito.verify(foodService, Mockito.times(1)).getFoodById(1L);
        Mockito.verify(foodService, Mockito.times(1)).getFoodById(1L);
        Mockito.verify(foodService, Mockito.times(1)).getFoodById(1L);
        Assertions.assertSame(order, orderFromService);

        ArgumentCaptor<Order> captor = ArgumentCaptor.forClass(Order.class);
        Mockito.verify(orderRepository, Mockito.times(1)).addOrder(captor.capture());
        Order capturedOrder = captor.getValue();
        Assertions.assertEquals(6, capturedOrder.getPrice());
        Assertions.assertEquals(0, capturedOrder.getOrderId());
        Assertions.assertEquals(foodList, capturedOrder.getFoodList());
    }
}