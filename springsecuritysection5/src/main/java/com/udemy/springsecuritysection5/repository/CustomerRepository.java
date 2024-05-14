package com.udemy.springsecuritysection5.repository;

import com.udemy.springsecuritysection5.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

  List<Customer> findByEmail(String email);
}
