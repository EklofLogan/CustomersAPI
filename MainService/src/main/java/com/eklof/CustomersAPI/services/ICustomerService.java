package com.eklof.CustomersAPI.services;

import com.eklof.CustomersAPI.models.Customer;


public interface ICustomerService {
    public Iterable<Customer> getCustomers();
    public Customer findCustomerById(Integer id);
    public Customer addCustomer(String first, String last, String email, String phoneNumber);
    public void deleteCustomer(Integer id);
}
