package com.geezylucas.springbootdddhexagonalexample.infrastructure.adapter.output.client;

import com.geezylucas.springbootdddhexagonalexample.application.port.output.InventoryOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class InventoryRestAdapter implements InventoryOutputPort {

    private final WebClient webClient;

    @Override
    public Mono<Boolean> checkInventory(Long productId, int quantity) {
        // Using WebClient
        /*
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/inventory/check")
                        .queryParam("productId", productId)
                        .queryParam("quantity", quantity)
                        .build())
                .retrieve()
                .bodyToMono(Boolean.class)
                .log();
         */

        return Mono.just(true); // Dummy value
    }
}