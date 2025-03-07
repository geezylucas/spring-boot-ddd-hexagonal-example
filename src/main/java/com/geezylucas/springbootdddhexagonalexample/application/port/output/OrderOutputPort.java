package com.geezylucas.springbootdddhexagonalexample.application.port.output;

import com.geezylucas.springbootdddhexagonalexample.domain.model.Order;
import com.geezylucas.springbootdddhexagonalexample.domain.model.OrderItem;
import reactor.core.publisher.Mono;

public interface OrderOutputPort {

    Mono<Order> save(Order order);

    Mono<OrderItem> saveOrderItems(Long orderId, OrderItem orderItem);

    Mono<Order> findById(Long orderId);
}
