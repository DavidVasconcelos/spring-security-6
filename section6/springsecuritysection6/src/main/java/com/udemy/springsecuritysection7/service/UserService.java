package com.udemy.springsecuritysection7.service;

import com.udemy.springsecuritysection7.model.Customer;

public interface UserService {

  void save(Customer customer);

  Customer findByEmail(String email);
}
