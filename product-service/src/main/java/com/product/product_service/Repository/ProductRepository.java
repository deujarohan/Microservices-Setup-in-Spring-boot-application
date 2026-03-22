package com.product.product_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.product_service.Model.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {}