package com.example.assignmentorder.service.impl;

import com.example.assignmentorder.entity.OrderDetail;
import com.example.assignmentorder.repository.OrderDetailRepository;
import com.example.assignmentorder.service.OrderDetailService;
import com.example.assignmentorder.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetail, Integer, OrderDetailRepository> implements OrderDetailService {
    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
        super(orderDetailRepository);
    }
}
