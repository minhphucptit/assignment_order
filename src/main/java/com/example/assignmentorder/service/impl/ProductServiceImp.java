package com.example.assignmentorder.service.impl;

import com.example.assignmentorder.entity.Product;
import com.example.assignmentorder.repository.ProductRepository;
import com.example.assignmentorder.service.ProductService;
import com.example.assignmentorder.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp extends BaseServiceImpl<Product, Integer, ProductRepository> implements ProductService {
    public ProductServiceImp(ProductRepository productRepository) {
        super(productRepository);
    }
}
