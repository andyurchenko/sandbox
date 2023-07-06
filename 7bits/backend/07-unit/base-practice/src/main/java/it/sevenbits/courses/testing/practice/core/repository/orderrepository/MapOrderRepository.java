package it.sevenbits.courses.testing.practice.core.repository.orderrepository;

import it.sevenbits.courses.testing.practice.core.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Database orders repository - implementation of OrderRepository
 *
 */
@Repository
public class MapOrderRepository implements IOrderRepository {
    private Map<Long, Order> orderMap;
    private final Order defaultOrder = new Order(-1, new ArrayList<>(), 0);
    /**
     * The basic constructor
     *
     * @param orderMap instance of a interface for work with database
     */
    public MapOrderRepository(final Map<Long, Order> orderMap) {
        this.orderMap = orderMap;
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(this.orderMap.values());
    }

    @Override
    public Order getOrderById(final long id) {
        return this.orderMap.getOrDefault(id, this.defaultOrder);
    }

    @Override
    public Order addOrder(final Order newOrder) {
        orderMap.put(newOrder.getOrderId(), newOrder);
        return orderMap.get(newOrder.getOrderId()); 
    }

}
