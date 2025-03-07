package com.geezylucas.springbootdddhexagonalexample.domain.service;

import com.geezylucas.springbootdddhexagonalexample.application.port.input.CreateOrderUseCase;
import com.geezylucas.springbootdddhexagonalexample.application.port.input.GetOrderUseCase;
import com.geezylucas.springbootdddhexagonalexample.application.port.output.InventoryOutputPort;
import com.geezylucas.springbootdddhexagonalexample.application.port.output.OrderOutputPort;
import com.geezylucas.springbootdddhexagonalexample.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OrderService implements CreateOrderUseCase, GetOrderUseCase {

    private final OrderOutputPort orderOutputPort;
    private final InventoryOutputPort inventoryOutputPort;

    @Override
    public Mono<Order> createOrder(Order order) {
        return orderOutputPort.save(order)
                .flatMap(orderSaved -> Flux.fromIterable(order.getItems())
                        .flatMap(orderItem -> inventoryOutputPort.checkInventory(orderItem.getProductId(), orderItem.getQuantity())
                                .flatMap(isAvailable -> {
                                    if (Boolean.FALSE.equals(isAvailable)) {
                                        return Mono.error(new RuntimeException("Insufficient inventory for product: " + orderItem.getProductId()));
                                    }

                                    return orderOutputPort.saveOrderItems(orderSaved.getId(), orderItem);
                                }))
                        .collectList()
                        .map(orderItems -> {
                            orderSaved.setItems(orderItems);
                            return orderSaved;
                        }));

    }

    @Override
    public Mono<Order> getOrder(Long orderId) {
        return orderOutputPort.findById(orderId);
    }
}
