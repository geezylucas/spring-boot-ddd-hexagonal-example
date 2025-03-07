package com.geezylucas.springbootdddhexagonalexample.infrastructure.adapter.output.persistence.repository;

import com.geezylucas.springbootdddhexagonalexample.infrastructure.adapter.output.persistence.entity.OrderItemEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface OrderItemRepository extends R2dbcRepository<OrderItemEntity, Long> {

    Flux<OrderItemEntity> findAllByOrderId(Long orderId);
}
