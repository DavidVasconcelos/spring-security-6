package com.udemy.springsecuritysection6.service;

import com.udemy.springsecuritysection6.model.Customer;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface EazyBankUserDetailsService extends UserDetailsService {

    Customer save(Customer customer);
}
