package com.vishnu.ordermanagement.service;

import com.vishnu.ordermanagement.entity.Order;
import org.springframework.data.domain.Page;

public interface OrderService {

    Order createOrder(Order order);

    Page<Order> getAllOrders(int page, int size, String sortBy);

    Order getOrderById(Long id);

    Order updateOrder(Long id, Order order);

    void deleteOrder(Long id);
}
