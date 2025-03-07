package com.geezylucas.springbootdddhexagonalexample.infrastructure.adapter.output.persistence.mapper;

import com.geezylucas.springbootdddhexagonalexample.domain.model.Order;
import com.geezylucas.springbootdddhexagonalexample.domain.model.OrderItem;
import com.geezylucas.springbootdddhexagonalexample.infrastructure.adapter.output.persistence.entity.OrderEntity;
import com.geezylucas.springbootdddhexagonalexample.infrastructure.adapter.output.persistence.entity.OrderItemEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class OrderMapper {

    public OrderEntity toOrderEntity(Order order) {
        return new OrderEntity(order.getId(), order.getStatus());
    }

    public OrderItemEntity toOrderItemEntity(Long orderId, OrderItem orderItem) {
        return new OrderItemEntity(orderItem.getProductId(), orderItem.getQuantity(), orderId);
    }

    public OrderItem toOrderItemDomain(OrderItemEntity orderItem) {
        return new OrderItem(orderItem.getProductId(), orderItem.getQuantity());
    }

    public Order toOrderDomain(OrderEntity orderEntity) {
        return new Order(orderEntity.getId(), new ArrayList<>(), orderEntity.getStatus());
    }
}
