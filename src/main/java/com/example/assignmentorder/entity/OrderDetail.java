package com.example.assignmentorder.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "order_details")
@Data
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

    private int quantity;
}
