package it.sevenbits.courses.testing.practice.core.repository.orderrepository;

import it.sevenbits.courses.testing.practice.core.model.Order;
import java.util.List;

/**
 * Interface for work with order repository
 *
 */
public interface IOrderRepository {

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
     * Method put new order in repository
     * @param order new Order
     * @return id of the new Order
     */

    Order addOrder(Order order);
}
