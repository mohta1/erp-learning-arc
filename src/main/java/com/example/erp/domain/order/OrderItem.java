package com.example.erp.domain.order;

public record OrderItem(
        Long productId,
        int quantity
) {}