package com.example.erp.application.order;

import com.example.erp.domain.order.*;
import com.example.erp.application.inventory.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateOrderUseCase {

    private final InventoryService inventoryService;
    private final OrderRepository orderRepository;

    @Transactional
    public Long execute(CreateOrderCommand cmd) {

        Order order = new Order(cmd.customerId(), cmd.items());

        // reserve stock
        for (OrderItem item : cmd.items()) {
            inventoryService.reserve(item.productId(), item.quantity());
        }

        order.confirm();

        Order saved = orderRepository.save(order);

        return saved.customerId(); // (placeholder id handling in v1)
    }
}