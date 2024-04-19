package com.example.assignmentorder.service.impl;

import com.example.assignmentorder.entity.Order;
import com.example.assignmentorder.repository.OrderRepository;
import com.example.assignmentorder.service.OrderService;
import com.example.assignmentorder.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl extends BaseServiceImpl<Order, Integer, OrderRepository> implements OrderService{
    public OrderServiceImpl(OrderRepository orderRepository){
        super(orderRepository);
    }
}
