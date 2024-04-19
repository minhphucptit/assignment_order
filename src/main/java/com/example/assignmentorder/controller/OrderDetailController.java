package com.example.assignmentorder.controller;

import com.example.assignmentorder.entity.OrderDetail;
import com.example.assignmentorder.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-details")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping
    public ResponseEntity<List<OrderDetail>> getAllOrderDetails() {
        List<OrderDetail> orderDetails = orderDetailService.findAll();
        return ResponseEntity.ok().body(orderDetails);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetail> getOrderDetailById(@PathVariable("id") Integer id) {
        var orderDetailOpt = orderDetailService.findById(id);

        if(orderDetailOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(orderDetailOpt.get());
    }

    @PostMapping
    public ResponseEntity<OrderDetail> createOrderDetail(@RequestBody OrderDetail orderDetail) {
        OrderDetail createdOrderDetail = orderDetailService.create(orderDetail);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderDetail);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDetail> updateOrderDetail(@PathVariable("id") Integer id, @RequestBody OrderDetail orderDetail) {

        if(orderDetailService.findById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }

        orderDetail.setId(id);
        OrderDetail updatedOrderDetail = orderDetailService.update(orderDetail);
        return ResponseEntity.ok().body(updatedOrderDetail);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrderDetail(@PathVariable("id") Integer id) {
        var orderDetailOpt = orderDetailService.findById(id);

        if(orderDetailOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        orderDetailService.delete(orderDetailOpt.get());

        return ResponseEntity.ok().build();
    }
}
