package com.example.assignmentorder.service.impl;

import com.example.assignmentorder.entity.Product;
import com.example.assignmentorder.repository.ProductRepository;
import com.example.assignmentorder.service.ProductService;
import com.example.assignmentorder.service.base.BaseServiceImpl;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp extends BaseServiceImpl<Product, Integer, ProductRepository> implements ProductService {
    public ProductServiceImp(ProductRepository productRepository) {
        super(productRepository);
    }

    @Override
    public List<Product> findByProductDetail(Product product) {
        return super.repository.findAll(Example.of(product, ExampleMatcher
                .matchingAll()
                .withIgnorePaths("id", "price", "quantity")
                .withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)));

    }
}
