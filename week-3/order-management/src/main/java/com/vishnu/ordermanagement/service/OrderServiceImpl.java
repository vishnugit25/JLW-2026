package com.vishnu.ordermanagement.service;

import com.vishnu.ordermanagement.entity.Order;
import com.vishnu.ordermanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    // Repository for database operations
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Page<Order> getAllOrders(int page, int size, String sortBy) {

        // Create pagination and sorting config
        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sortBy)
        );

        return orderRepository.findAll(pageable);
    }

    @Override
    public Order getOrderById(Long id) {

        // Fetch order or throw exception
        return orderRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found with ID: " + id));
    }

    @Override
    public Order updateOrder(Long id, Order updatedOrder) {

        // Get existing order
        Order existingOrder = getOrderById(id);

        // Update fields
        existingOrder.setCustomerName(updatedOrder.getCustomerName());
        existingOrder.setOrderDate(updatedOrder.getOrderDate());
        existingOrder.setOrderItems(updatedOrder.getOrderItems());

        return orderRepository.save(existingOrder);
    }

    @Override
    public void deleteOrder(Long id) {

        // Verify order exists before deleting
        Order order = getOrderById(id);

        orderRepository.delete(order);
    }
}