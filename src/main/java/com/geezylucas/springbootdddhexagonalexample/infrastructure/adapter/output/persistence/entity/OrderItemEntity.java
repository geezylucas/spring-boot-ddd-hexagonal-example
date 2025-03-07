package com.geezylucas.springbootdddhexagonalexample.infrastructure.adapter.output.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("order_items")
@Data
@AllArgsConstructor
public class OrderItemEntity {

    @Id
    private Long productId;
    private int quantity;
    private Long orderId;
}