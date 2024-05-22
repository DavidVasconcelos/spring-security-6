package com.udemy.springsecuritysection9.service;

import com.udemy.springsecuritysection9.model.Customer;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface EazyBankUserDetailsService {

  Customer save(Customer customer);
}
