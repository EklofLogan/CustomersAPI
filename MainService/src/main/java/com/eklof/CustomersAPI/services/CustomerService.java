package com.eklof.CustomersAPI.services;

import com.eklof.CustomersAPI.exceptions.DuplicateCustomerException;
import com.eklof.CustomersAPI.exceptions.NoSuchCustomerException;
import com.eklof.CustomersAPI.models.Customer;
import com.eklof.CustomersAPI.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    private Object NoSuchCustomerException;

    @Override
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerById(Integer id) {
        if (!customerRepository.existsById(id)) {
            throw new NoSuchCustomerException(id);
        }
        return customerRepository.findCustomerById(id);
    }

    @Override
    public Customer addCustomer(String first, String last, String email, String phoneNumber) {
        Customer customer = new Customer();
        customer.setFirstName(first);
        customer.setLastName(last);
        customer.setEmail(email);
        customer.setPhoneNumber(phoneNumber);
        Iterable<Customer> customers = customerRepository.findAll();
        customers.forEach(new Consumer<Customer>() {

            @Override
            public void accept(Customer cust) {
                Boolean duplicate = false;
                if (cust.getFirstName().equals(first) && cust.getLastName().equals(last) && cust.getEmail().equals(email) && cust.getPhoneNumber().equals(phoneNumber)) {
                    duplicate = true;
                }
                if (duplicate) {
                    throw new DuplicateCustomerException();
                }
            }

        });
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public void deleteCustomer(Integer id) {
        if (!customerRepository.existsById(id)) {
            throw new NoSuchCustomerException(id);
        }
        customerRepository.deleteById(id);
    }
}
