package com.example.erp.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringOrderRepository extends JpaRepository<OrderEntity, Long> {
}