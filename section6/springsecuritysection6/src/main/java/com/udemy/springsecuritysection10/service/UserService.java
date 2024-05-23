package com.udemy.springsecuritysection10.service;

import com.udemy.springsecuritysection10.model.Customer;

public interface UserService {

  void save(Customer customer);

  Customer findByEmail(String email);
}
