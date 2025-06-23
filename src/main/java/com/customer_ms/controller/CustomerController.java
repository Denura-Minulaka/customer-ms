package com.customer_ms.controller;

import com.customer_ms.data.Customer;
import com.customer_ms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllLCustomers();
    }

    @PostMapping("/customers/signup")
    public String signup(@RequestBody Customer customer) {
        return customerService.signup(customer);
    }

    @PostMapping("/customers/login")
    public String login(@RequestBody Customer customer) {
        return customerService.login(customer);
    }

    @GetMapping("/customers/{id}")
    public Customer viewAccount(@PathVariable int id) {
        return customerService.viewAccount(id);
    }

    @DeleteMapping("/customers/{id}")
    public String deleteAccount(@PathVariable int id) {
        return customerService.deleteAccount(id);
    }

    @PutMapping("/customers")
    public Customer updateAccount(@RequestBody Customer customer) {
        return customerService.updateAccount(customer);
    }
}
