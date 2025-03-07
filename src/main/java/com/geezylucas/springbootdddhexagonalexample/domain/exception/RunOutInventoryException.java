package com.geezylucas.springbootdddhexagonalexample.domain.exception;

public class RunOutInventoryException extends RuntimeException {
    public RunOutInventoryException(String message) {
        super(message);
    }
}
