package com.udemy.springsecuritysection5.service;

import com.udemy.springsecuritysection5.model.Customer;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface EazyBankUserDetailsService {

  Customer save(Customer customer);
}
