package com.udemy.springsecuritysection9.repository;

import com.udemy.springsecuritysection9.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

  List<Customer> findByEmail(String email);
}
