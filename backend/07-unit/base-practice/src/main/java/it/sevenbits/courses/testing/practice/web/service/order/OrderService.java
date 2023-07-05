package it.sevenbits.courses.testing.practice.web.service.order;

import it.sevenbits.courses.testing.practice.core.model.Food;
import it.sevenbits.courses.testing.practice.core.model.Order;
import it.sevenbits.courses.testing.practice.core.repository.orderrepository.IOrderRepository;
import it.sevenbits.courses.testing.practice.web.model.OrderRequestBody;
import it.sevenbits.courses.testing.practice.web.service.food.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This is service for a service that managing orders
 */

@Service
public class OrderService implements IOrderService {

    private IOrderRepository orderRepository;
    private IFoodService foodService;

    private long idCounter = 0;

    /**
     * The basic constructor
     *
     * @param orderRepository - order repository
     * @param foodService     - food service for actions
     */
    @Autowired
    public OrderService(final IOrderRepository orderRepository, final IFoodService foodService) {
        this.orderRepository = orderRepository;
        this.foodService = foodService;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @Override
    public Order getOrderById(final long id) {
        return orderRepository.getOrderById(id);
    }

    @Override
    public Order createNewOrder(final OrderRequestBody requestBody) {
        long price = 0;
        List<Food> foodList = new ArrayList<>();
        for (long foodId : requestBody.getFoodIdList()) {
            Food requestedFood = foodService.getFoodById(foodId);
            price += requestedFood.getPrice();
            foodList.add(requestedFood);
        }

        long id = generateNewId();

        Order newOrder = new Order(id, foodList, price);

        return orderRepository.addOrder(newOrder);
    }

    private long generateNewId() {
        long result = idCounter;
        idCounter += 1;
        return result;
    }
}
