package com.example.erp.infrastructure.adapter;

import com.example.erp.application.order.OrderRepository;
import com.example.erp.domain.order.Order;
import com.example.erp.infrastructure.persistence.OrderEntity;
import com.example.erp.infrastructure.persistence.SpringOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final SpringOrderRepository repo;

    @Override
    public Order save(Order order) {

        OrderEntity entity = new OrderEntity();
        entity.setCustomerId(order.customerId());
        entity.setStatus(order.status().name());

        repo.save(entity);

        return order;
    }
}