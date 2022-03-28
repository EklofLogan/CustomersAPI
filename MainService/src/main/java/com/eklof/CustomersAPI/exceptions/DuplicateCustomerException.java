package com.eklof.CustomersAPI.exceptions;

public class DuplicateCustomerException extends RuntimeException{
    public DuplicateCustomerException() {
        super(String.format("Customer with this information already exists."));
    }
}
