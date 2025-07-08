package com.customer_ms.controller;

import com.customer_ms.data.Customer;
import com.customer_ms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllLCustomers();
    }

    @PostMapping("/customers/signup")
    public ResponseEntity<Customer> signup(@RequestBody Customer customer) {
        Customer signupResult = customerService.signup(customer);
        return ResponseEntity.ok(signupResult);
    }

    @PostMapping("/customers/login")
    public ResponseEntity<Customer> login(@RequestBody Customer customer) {
        Customer result = customerService.login(customer);
        return ResponseEntity.ok(result); // returns whole customer object (without password)

    }


    @GetMapping("/customers/{id}")
    public Customer viewAccount(@PathVariable int id) {
        return customerService.viewAccount(id);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteAccount(@PathVariable int id) {
        customerService.deleteAccount(id);
    }

    @PutMapping("/customers/update")
    public ResponseEntity<Customer> updateAccount(@RequestBody Customer customer) {
        Customer updateResult = customerService.updateAccount(customer);
        return ResponseEntity.ok(updateResult);
    }
}
