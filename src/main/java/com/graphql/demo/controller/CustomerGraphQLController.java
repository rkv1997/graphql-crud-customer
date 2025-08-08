package com.graphql.demo.controller;

import com.graphql.demo.dto.CustomerInput;
import com.graphql.demo.dto.UpdateCustomerInput;
import com.graphql.demo.entity.Customer;
import com.graphql.demo.repository.CustomerRepository;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CustomerGraphQLController {

    private final CustomerRepository repository;

    public CustomerGraphQLController(CustomerRepository repository) {
        this.repository = repository;
    }

    @QueryMapping
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @QueryMapping
    public Customer getCustomerByEmail(@Argument String email) {
        return repository.findByEmail(email);
    }

    @QueryMapping
    public List<Customer> getCustomersByCity(@Argument String city) {
        return repository.findByCity(city);
    }

    @MutationMapping
    public Customer addCustomer(@Argument CustomerInput input) {
        Customer customer = new Customer();
        customer.setName(input.name());
        customer.setEmail(input.email());
        customer.setCity(input.city());
        return repository.save(customer);
    }

    @MutationMapping
    public Customer updateCustomer(@Argument UpdateCustomerInput input) {
        Customer customer = repository.findById(input.id())
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + input.id()));

        if (input.name() != null) customer.setName(input.name());
        if (input.email() != null) customer.setEmail(input.email());
        if (input.city() != null) customer.setCity(input.city());

        return repository.save(customer);
    }

    @MutationMapping
    public Boolean deleteCustomer(@Argument String id) {
        long customerId = Long.parseLong(id);
        if (!repository.existsById(customerId)) {
            throw new RuntimeException("Customer not found with id: " + id);
        }
        repository.deleteById(customerId);
        return true;
    }


}

