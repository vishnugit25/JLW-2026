package com.vishnu.ordermanagement.controller;

import com.vishnu.ordermanagement.entity.Order;
import com.vishnu.ordermanagement.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    // Service layer object
    @Autowired
    private OrderService orderService;

    // Create a new order
    @PostMapping
    public Order createOrder(@Valid @RequestBody Order order) {
        return orderService.createOrder(order);
    }

    // Get all orders with pagination and sorting
    @GetMapping
    public Page<Order> getAllOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        return orderService.getAllOrders(page, size, sortBy);
    }

    // Get order by ID
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    // Update order details
    @PutMapping("/{id}")
    public Order updateOrder(
            @PathVariable Long id,
            @Valid @RequestBody Order order) {

        return orderService.updateOrder(id, order);
    }

    // Delete order by ID
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {

        orderService.deleteOrder(id);

        return "Order deleted successfully";
    }
}