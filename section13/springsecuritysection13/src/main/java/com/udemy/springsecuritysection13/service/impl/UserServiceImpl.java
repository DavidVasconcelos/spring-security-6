package com.udemy.springsecuritysection13.service.impl;

import com.udemy.springsecuritysection13.model.Customer;
import com.udemy.springsecuritysection13.repository.CustomerRepository;
import com.udemy.springsecuritysection13.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final CustomerRepository customerRepository;

  public UserServiceImpl(final CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public Customer findByEmail(final String email) {
    return customerRepository.findByEmail(email).stream().findFirst().orElse(null);
  }
}
