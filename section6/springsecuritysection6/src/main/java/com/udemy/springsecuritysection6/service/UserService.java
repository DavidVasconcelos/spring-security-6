package com.udemy.springsecuritysection6.service;

import com.udemy.springsecuritysection6.model.Customer;

public interface UserService {

  void save(Customer customer);

  Customer findByEmail(String email);
}
