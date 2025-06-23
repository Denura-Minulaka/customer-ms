package com.customer_ms.service;

import com.customer_ms.data.Customer;
import com.customer_ms.data.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    public List<Customer> getAllLCustomers(){
        return customerRepo.findAll();
    }

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String signup(Customer customer) {
        if (customerRepo.findByUsername(customer.getUsername()) != null) {
            return "Username already exists!";
        }

        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerRepo.save(customer);
        return "Signup successful!";
    }

    public String login(Customer customer) {
        Customer existingCustomer = customerRepo.findByUsername(customer.getUsername());
        if (existingCustomer != null && passwordEncoder.matches(customer.getPassword(), existingCustomer.getPassword())) {
            return "Login successful!";
        } else {
            return "Invalid username or password!";
        }
    }

    public Customer viewAccount(int id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent()) {
            return customer.get();
        }
        return null;
    }

    public String deleteAccount(int id) {
        customerRepo.deleteById(id);
        return "Account deleted successfully!";
    }

    public Customer updateAccount(Customer updatedCustomer) {

        if (updatedCustomer.getPassword() != null && !updatedCustomer.getPassword().isEmpty()) {
            updatedCustomer.setPassword(passwordEncoder.encode(updatedCustomer.getPassword()));
        }

        return customerRepo.save(updatedCustomer);
    }



}
