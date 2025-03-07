package com.geezylucas.springbootdddhexagonalexample.infrastructure.adapter.input.rest;

import com.geezylucas.springbootdddhexagonalexample.application.port.input.CreateOrderUseCase;
import com.geezylucas.springbootdddhexagonalexample.application.port.input.GetOrderUseCase;
import com.geezylucas.springbootdddhexagonalexample.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderRestAdapter {

    private final CreateOrderUseCase createOrderUseCase;
    private final GetOrderUseCase getOrderUseCase;

    @PostMapping
    public Mono<Order> createOrder(@RequestBody Order order) {
        return createOrderUseCase.createOrder(order);
    }

    @GetMapping("/{orderId}")
    public Mono<Order> getOrder(@PathVariable Long orderId) {
        return getOrderUseCase.getOrder(orderId);
    }
}
