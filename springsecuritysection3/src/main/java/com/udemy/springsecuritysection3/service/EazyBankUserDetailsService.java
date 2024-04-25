package com.udemy.springsecuritysection3.service;

import com.udemy.springsecuritysection3.model.Customer;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface EazyBankUserDetailsService extends UserDetailsService {

    Customer save(Customer customer);
}
