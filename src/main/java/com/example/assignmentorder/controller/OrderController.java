package com.example.assignmentorder.controller;

import com.example.assignmentorder.entity.Order;
import com.example.assignmentorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.findAll();
        return ResponseEntity.ok().body(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Integer id) {
        var orderOpt = orderService.findById(id);

        if(orderOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(orderOpt.get());
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.create(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") Integer id, @RequestBody Order order) {

        if(orderService.findById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }

        order.setId(id);
        Order updatedOrder = orderService.update(order);
        return ResponseEntity.ok().body(updatedOrder);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") Integer id) {
        var orderOpt = orderService.findById(id);

        if(orderOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        orderService.delete(orderOpt.get());

        return ResponseEntity.ok().build();
    }
}
