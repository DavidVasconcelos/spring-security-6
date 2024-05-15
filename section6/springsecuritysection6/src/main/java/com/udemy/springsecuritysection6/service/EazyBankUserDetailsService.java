package com.udemy.springsecuritysection6.service;

import com.udemy.springsecuritysection6.model.Customer;

public interface EazyBankUserDetailsService {

  Customer save(Customer customer);
}
