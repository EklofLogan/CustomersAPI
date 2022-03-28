package com.eklof.CustomersAPI.exceptions;

public class NoSuchCustomerException extends RuntimeException{
    public NoSuchCustomerException(Integer id) {
        super(String.format("No customer with id %d",id));
    }
}
