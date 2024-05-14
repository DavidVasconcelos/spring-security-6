package com.udemy.springsecuritysection4.service;

import com.udemy.springsecuritysection4.model.Customer;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface EazyBankUserDetailsService extends UserDetailsService {

    Customer save(Customer customer);
}
