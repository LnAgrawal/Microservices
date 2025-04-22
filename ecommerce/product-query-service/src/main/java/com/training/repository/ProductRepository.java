package com.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
