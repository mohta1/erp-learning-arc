package com.example.erp.interfaces.rest;

import com.example.erp.application.order.CreateOrderCommand;
import com.example.erp.application.order.CreateOrderUseCase;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final CreateOrderUseCase useCase;

    public OrderController(CreateOrderUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public Long create(@RequestBody @Valid CreateOrderCommand cmd) {
        return useCase.execute(cmd);
    }
}