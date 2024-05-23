package com.udemy.springsecuritysection10.service;

import com.udemy.springsecuritysection10.model.Customer;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface EazyBankUserDetailsService extends UserDetailsService {

    Customer save(Customer customer);
}
