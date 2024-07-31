package com.RestroManagement.product_service.Exceptions;

public class ProductNotAvailableException extends RuntimeException{
    public ProductNotAvailableException(String message) {
        super(message);
    }
}
