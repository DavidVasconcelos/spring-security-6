package com.udemy.springsecuritysection7.service;

import com.udemy.springsecuritysection7.model.Customer;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface EazyBankUserDetailsService {

  Customer save(Customer customer);
}
