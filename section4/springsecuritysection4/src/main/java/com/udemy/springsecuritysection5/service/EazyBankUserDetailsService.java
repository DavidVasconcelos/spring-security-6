package com.udemy.springsecuritysection13.service;

import com.udemy.springsecuritysection13.model.Customer;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface EazyBankUserDetailsService extends UserDetailsService {

    Customer save(Customer customer);
}
