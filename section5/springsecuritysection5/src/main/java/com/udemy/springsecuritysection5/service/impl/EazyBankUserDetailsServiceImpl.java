package com.udemy.springsecuritysection8.service.impl;

import com.udemy.springsecuritysection8.model.Customer;
import com.udemy.springsecuritysection8.repository.CustomerRepository;
import com.udemy.springsecuritysection8.service.EazyBankUserDetailsService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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
