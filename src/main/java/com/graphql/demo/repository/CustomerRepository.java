package com.graphql.demo.repository;

import com.graphql.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByCity(String city);
    Customer findByEmail(String email);
}

