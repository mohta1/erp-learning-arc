package com.example.erp.application.order;

import com.example.erp.domain.order.OrderItem;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateOrderCommand(
        @NotNull Long customerId,
        @NotNull List<OrderItem> items
) {}