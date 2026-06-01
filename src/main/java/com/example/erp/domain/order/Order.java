package com.example.erp.domain.order;

import java.util.List;

public class Order {

    private Long id;
    private Long customerId;
    private List<OrderItem> items;
    private OrderStatus status;

    public Order(Long customerId, List<OrderItem> items) {
        this.customerId = customerId;
        this.items = items;
        this.status = OrderStatus.CREATED;
    }

    public void confirm() {
        if (items == null || items.isEmpty()) {
            throw new IllegalStateException("Order must have items");
        }
        this.status = OrderStatus.CONFIRMED;
    }

    public Long customerId() {
        return customerId;
    }

    public List<OrderItem> items() {
        return items;
    }

    public OrderStatus status() {
        return status;
    }
}