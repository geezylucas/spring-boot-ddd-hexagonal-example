package com.geezylucas.springbootdddhexagonalexample.infrastructure.adapter.output.persistence;

import com.geezylucas.springbootdddhexagonalexample.application.port.output.OrderOutputPort;
import com.geezylucas.springbootdddhexagonalexample.domain.exception.OrderNotFoundException;
import com.geezylucas.springbootdddhexagonalexample.domain.model.Order;
import com.geezylucas.springbootdddhexagonalexample.domain.model.OrderItem;
import com.geezylucas.springbootdddhexagonalexample.infrastructure.adapter.output.persistence.mapper.OrderMapper;
import com.geezylucas.springbootdddhexagonalexample.infrastructure.adapter.output.persistence.repository.OrderItemRepository;
import com.geezylucas.springbootdddhexagonalexample.infrastructure.adapter.output.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class OrderPersistenceAdapter implements OrderOutputPort {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderMapper orderMapper;

    @Override
    public Mono<Order> save(Order order) {
        return orderRepository.save(orderMapper.toOrderEntity(order))
                .map(orderMapper::toOrderDomain);
    }

    @Override
    public Mono<OrderItem> saveOrderItems(Long orderId, OrderItem orderItem) {
        return orderItemRepository.save(orderMapper.toOrderItemEntity(orderId, orderItem))
                .map(orderMapper::toOrderItemDomain);
    }

    @Override
    public Mono<Order> findById(Long orderId) {
        return orderRepository.findById(orderId)
                .map(orderMapper::toOrderDomain)
                .switchIfEmpty(Mono.error(new OrderNotFoundException("Order not found!")));
    }
}
