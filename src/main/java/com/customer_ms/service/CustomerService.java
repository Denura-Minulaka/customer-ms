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
    @Autowired
    private ContractInterService contractService;

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

    public Customer login(Customer customer) {
        Customer existingCustomer = customerRepo.findByUsername(customer.getUsername());
        if (existingCustomer != null && passwordEncoder.matches(customer.getPassword(), existingCustomer.getPassword())) {
            existingCustomer.setPassword(null); // Hide the password
            return existingCustomer;
        } else {
            return null;
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
        contractService.cancelContractForCustomer(id); //cancelling the contracts for the deleted customer
        return "Account deleted successfully!";
    }

    public Customer updateAccount(Customer updatedCustomer) {
        Optional<Customer> optionalCustomer = customerRepo.findById(updatedCustomer.getId());

        if (updatedCustomer.getPassword() != null && !updatedCustomer.getPassword().isEmpty()) {
            updatedCustomer.setPassword(passwordEncoder.encode(updatedCustomer.getPassword()));
        }else {
            updatedCustomer.setPassword(optionalCustomer.get().getPassword());
        }

        return customerRepo.save(updatedCustomer);
    }



}
