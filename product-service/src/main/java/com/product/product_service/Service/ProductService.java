package com.product.product_service.Service;

import com.product.product_service.Model.Product;
import com.product.product_service.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
}