package com.vishnu.ordermanagement.repository;

import com.vishnu.ordermanagement.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}