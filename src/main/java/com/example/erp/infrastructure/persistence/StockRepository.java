package com.example.erp.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<StockEntity, Long> {

    Optional<StockEntity> findByProductId(Long productId);
}