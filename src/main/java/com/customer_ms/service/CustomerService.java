package com.customer_ms.service;

import com.customer_ms.data.Customer;
import com.customer_ms.data.CustomerRepository;
import com.customer_ms.service.interservice.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepo;
    @Autowired
    private ContractService contractService;

    public List<Customer> getAllLCustomers(){
        return customerRepo.findAll();
    }

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Customer signup(Customer customer) {
        if (customerRepo.findByUsername(customer.getUsername()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists!");
        }

        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerRepo.save(customer);
    }

    public Customer login(Customer customer) {
        Customer existingCustomer = customerRepo.findByUsername(customer.getUsername());
        if (existingCustomer != null && passwordEncoder.matches(customer.getPassword(), existingCustomer.getPassword())) {
            existingCustomer.setPassword(null); // Hide the password
            return existingCustomer;
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password is wrong!");
        }
    }


    public Customer viewAccount(int id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent()) {
            return customer.get();
        }
        return null;
    }

    public void deleteAccount(int id) {
        customerRepo.deleteById(id);
        contractService.cancelContractForCustomer(id); //cancelling the contracts for the deleted customer
    }

    public Customer updateAccount(Customer updatedCustomer) {
        Optional<Customer> optionalCustomer = customerRepo.findById(updatedCustomer.getId());

        if (customerRepo.findByUsername(updatedCustomer.getUsername()) != null && !updatedCustomer.getUsername().equals(optionalCustomer.get().getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists!");
        }

        if (updatedCustomer.getPassword() != null && !updatedCustomer.getPassword().isEmpty()) {
            updatedCustomer.setPassword(passwordEncoder.encode(updatedCustomer.getPassword()));
        }else {
            updatedCustomer.setPassword(optionalCustomer.get().getPassword());
        }

        return customerRepo.save(updatedCustomer);
    }

    public Boolean customerExistsById(int id){
        return customerRepo.existsById(id);
    }



}
