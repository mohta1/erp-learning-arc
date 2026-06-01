package com.example.erp.domain.inventory;

public class StockItem {

    private Long productId;
    private int quantity;

    public StockItem(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public void reserve(int qty) {
        if (quantity < qty) {
            throw new IllegalStateException("Not enough stock");
        }
        quantity -= qty;
    }

    public Long productId() {
        return productId;
    }

    public int quantity() {
        return quantity;
    }
}