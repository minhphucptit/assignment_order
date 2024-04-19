package com.example.assignmentorder.repository;

import com.example.assignmentorder.entity.OrderDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends BaseRepository<OrderDetail, Integer> {
}
