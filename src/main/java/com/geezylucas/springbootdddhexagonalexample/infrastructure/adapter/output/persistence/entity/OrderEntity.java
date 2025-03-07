package com.geezylucas.springbootdddhexagonalexample.infrastructure.adapter.output.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("orders")
@Data
@Builder
@AllArgsConstructor
public class OrderEntity {

    @Id
    private Long id;
    private String status;
}