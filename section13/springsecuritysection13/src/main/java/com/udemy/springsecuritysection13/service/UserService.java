package com.udemy.springsecuritysection13.service;

import com.udemy.springsecuritysection13.model.Customer;

public interface UserService {

  Customer findByEmail(String email);
}
