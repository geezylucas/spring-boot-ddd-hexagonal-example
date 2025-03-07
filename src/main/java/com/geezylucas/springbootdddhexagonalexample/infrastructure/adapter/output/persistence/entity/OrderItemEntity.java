package com.geezylucas.springbootdddhexagonalexample.infrastructure.adapter.output.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("order_items")
@Data
@Builder
@AllArgsConstructor
public class OrderItemEntity {

    @Id
    private Long id;
    @Column("product_id")
    private Long productId;
    private int quantity;
    @Column("order_id")
    private Long orderId;
}