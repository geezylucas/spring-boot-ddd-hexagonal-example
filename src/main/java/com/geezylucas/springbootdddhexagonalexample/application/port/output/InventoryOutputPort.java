package com.geezylucas.springbootdddhexagonalexample.application.port.output;

import reactor.core.publisher.Mono;

public interface InventoryOutputPort {

    Mono<Boolean> checkInventory(Long productId, int quantity);
}
