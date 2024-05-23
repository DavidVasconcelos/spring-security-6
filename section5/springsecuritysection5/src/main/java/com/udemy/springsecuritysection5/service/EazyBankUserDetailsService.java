package com.udemy.springsecuritysection10.service;

import com.udemy.springsecuritysection10.model.Customer;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface EazyBankUserDetailsService {

  Customer save(Customer customer);
}
