package com.udemy.springsecuritysection13.service;

import com.udemy.springsecuritysection13.model.Customer;

public interface UserService {

  void save(Customer customer);

  Customer findByEmail(String email);
}
