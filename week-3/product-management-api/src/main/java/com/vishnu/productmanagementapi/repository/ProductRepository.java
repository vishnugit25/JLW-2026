package com.vishnu.productmanagementapi.repository;

import com.vishnu.productmanagementapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}