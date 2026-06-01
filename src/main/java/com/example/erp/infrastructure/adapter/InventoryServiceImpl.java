package com.example.erp.infrastructure.adapter;

import com.example.erp.application.inventory.InventoryService;
import com.example.erp.infrastructure.persistence.StockRepository;
import com.example.erp.infrastructure.persistence.StockEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final StockRepository repo;

    @Override
    public void reserve(Long productId, int qty) {

        StockEntity stock = repo.findByProductId(productId)
                .orElseThrow(() -> new RuntimeException("Stock not found"));

        if (stock.getQuantity() < qty) {
            throw new RuntimeException("Out of stock");
        }

        stock.setQuantity(stock.getQuantity() - qty);

        repo.save(stock);
    }
}