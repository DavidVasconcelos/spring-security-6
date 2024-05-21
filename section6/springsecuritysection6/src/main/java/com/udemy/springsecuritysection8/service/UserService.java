package com.udemy.springsecuritysection8.service;

import com.udemy.springsecuritysection8.model.Customer;

public interface UserService {

  void save(Customer customer);

  Customer findByEmail(String email);
}
