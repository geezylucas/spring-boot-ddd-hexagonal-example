package com.geezylucas.springbootdddhexagonalexample.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Order {

    private Long id;
    private List<OrderItem> items;
    private String status;
}