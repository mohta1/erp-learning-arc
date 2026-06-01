package com.example.erp.application.order;

import com.example.erp.domain.order.Order;

public interface OrderRepository {
    Order save(Order order);
}