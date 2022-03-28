package com.eklof.CustomersAPI.controllers;

import com.eklof.CustomersAPI.models.Customer;
import com.eklof.CustomersAPI.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping()
    public Customer addCustomer(@RequestParam String firstName,@RequestParam String lastName,@RequestParam String email,@RequestParam String phoneNumber) {
        return customerService.addCustomer(firstName, lastName, email, phoneNumber);
    }

    @GetMapping("/list")
    public Iterable<Customer> getCustomers() { return customerService.getCustomers(); }

    @GetMapping("/find/{id}")
    public Customer findCustomerById(@PathVariable Integer id) {
        return customerService.findCustomerById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable Integer id) { customerService.deleteCustomer(id); }
}