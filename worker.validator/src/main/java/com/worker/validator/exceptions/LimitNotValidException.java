package com.worker.validator.exceptions;


import com.worker.validator.model.Order;

public class LimitNotValidException extends RuntimeException{
    public LimitNotValidException(String message) {
        super(message);
    }
    public LimitNotValidException(String message, Order order) {
        super(message + " Limit available : "+order.getCreditCard().availableLimit+ " . Order price : "+order.getValue());
    }
}
