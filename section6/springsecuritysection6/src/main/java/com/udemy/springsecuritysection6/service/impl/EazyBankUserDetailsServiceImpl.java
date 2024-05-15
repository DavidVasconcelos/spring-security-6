package com.udemy.springsecuritysection6.service.impl;

import com.udemy.springsecuritysection6.model.Customer;
import com.udemy.springsecuritysection6.repository.CustomerRepository;
import com.udemy.springsecuritysection6.service.EazyBankUserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EazyBankUserDetailsServiceImpl implements EazyBankUserDetailsService {

  private final CustomerRepository customerRepository;
  private final PasswordEncoder passwordEncoder;

  public EazyBankUserDetailsServiceImpl(final CustomerRepository customerRepository,
      final PasswordEncoder passwordEncoder) {
    this.customerRepository = customerRepository;
    this.passwordEncoder = passwordEncoder;
  }

 @Override
  public Customer save(final Customer customer) {
    final String hashPwd = passwordEncoder.encode(customer.getPwd());
    customer.setPwd(hashPwd);
    return customerRepository.save(customer);
  }
}
