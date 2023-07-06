package it.sevenbits.courses.testing.practice.web.service.order;

import it.sevenbits.courses.testing.practice.core.model.Order;
import it.sevenbits.courses.testing.practice.web.model.OrderRequestBody;

import java.util.List;

/**
 * Interface for work with order service
 */
public interface IOrderService {

    /**
     * This method returns all existing orders
     * @return list of orders
     */
    List<Order> getAllOrders();

    /**
     * Method returns the order by id
     * @param id unique identifier
     * @return instance of the order
     */
    Order getOrderById(long id);

    /**
     * Method creates new order
     * @param requestBody model with required data
     * @return instance of the new order
     */
     Order createNewOrder(OrderRequestBody requestBody);
}
