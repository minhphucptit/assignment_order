package com.example.assignmentorder.service;

import com.example.assignmentorder.entity.Product;
import com.example.assignmentorder.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService extends BaseService<Product, Integer> {

    List<Product> findByProductDetail(Product product);
}
