package com.udemy.springsecuritysection9.service;

import com.udemy.springsecuritysection9.model.Customer;

public interface UserService {

  void save(Customer customer);

  Customer findByEmail(String email);
}
