package com.geezylucas.springbootdddhexagonalexample.application.port.input;

import com.geezylucas.springbootdddhexagonalexample.domain.model.Order;
import reactor.core.publisher.Mono;

public interface GetOrderUseCase {

    Mono<Order> getOrder(Long orderId);
}
