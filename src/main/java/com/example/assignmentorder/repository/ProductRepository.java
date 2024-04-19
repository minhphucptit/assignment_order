package com.example.assignmentorder.repository;

import com.example.assignmentorder.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseRepository<Product, Integer> {
}
