package com.example.erp.application.inventory;

public interface InventoryService {
    void reserve(Long productId, int qty);
}