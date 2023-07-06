package it.sevenbits.courses.testing.practice.web.controller;

import it.sevenbits.courses.testing.practice.core.model.Order;
import it.sevenbits.courses.testing.practice.web.model.OrderRequestBody;
import it.sevenbits.courses.testing.practice.web.service.order.IOrderService;
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
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Controller for the order endpoint
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    private final IOrderService orderService;

    /**
     * Basic constructor
     * @param orderService order service
     */
    @Autowired
    public OrderController(final IOrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * This method returns all existing orders
     * @return response entity with list of Order objects
     */
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Order>> getAllOrders() {
        try {
            List<Order> orderList = orderService.getAllOrders();
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(orderList);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Method returns the order by id
     * @param id unique identifier of order
     * @return response entity with order
     */
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Order> getOrderById(final @PathVariable("id") long id) {
        try {
            Order order = orderService.getOrderById(id);
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(order);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Method creates new Order
     * @param requestBody request model with required parameter for creation
     * @return response entity with order
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<Order> getNewOrder(final @RequestBody OrderRequestBody requestBody) {
        try {
            Order order = orderService.createNewOrder(requestBody);
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(order);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
