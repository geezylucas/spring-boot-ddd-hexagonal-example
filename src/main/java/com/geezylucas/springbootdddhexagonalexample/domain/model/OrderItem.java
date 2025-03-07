package com.geezylucas.springbootdddhexagonalexample.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItem {

    private Long productId;
    private int quantity;
}