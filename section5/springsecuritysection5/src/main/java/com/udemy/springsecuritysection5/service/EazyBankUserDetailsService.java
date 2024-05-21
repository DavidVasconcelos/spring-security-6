package com.udemy.springsecuritysection8.service;

import com.udemy.springsecuritysection8.model.Customer;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface EazyBankUserDetailsService {

  Customer save(Customer customer);
}
