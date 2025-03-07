package com.geezylucas.springbootdddhexagonalexample.domain.model;

public enum OrderStatus {
    PENDING,
    PROCESSING,
    SHIPPED,
    DELIVERED,
    CANCELED,
    RETURNED;

    // Optional: Add methods to provide more information or functionality
    public String getDescription() {
        return switch (this) {
            case PENDING -> "Order is pending confirmation.";
            case PROCESSING -> "Order is being processed.";
            case SHIPPED -> "Order has been shipped.";
            case DELIVERED -> "Order has been delivered.";
            case CANCELED -> "Order has been canceled.";
            case RETURNED -> "Order has been returned.";
        };
    }
}
