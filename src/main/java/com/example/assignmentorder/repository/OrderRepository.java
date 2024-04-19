package com.example.assignmentorder.repository;

import com.example.assignmentorder.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends BaseRepository<Order, Integer> {
}
