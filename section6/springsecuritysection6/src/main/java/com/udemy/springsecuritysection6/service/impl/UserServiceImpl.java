package com.udemy.springsecuritysection6.service.impl;

import com.udemy.springsecuritysection6.model.Customer;
import com.udemy.springsecuritysection6.repository.CustomerRepository;
import com.udemy.springsecuritysection6.service.UserService;
import java.time.LocalDate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final CustomerRepository customerRepository;
  private final PasswordEncoder passwordEncoder;

  public UserServiceImpl(final CustomerRepository customerRepository,
      final PasswordEncoder passwordEncoder) {
    this.customerRepository = customerRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public void save(final Customer customer) {
    final String hashPwd = passwordEncoder.encode(customer.getPwd());
    customer.setPwd(hashPwd);
    customer.setCreateDt(LocalDate.now());
    customerRepository.save(customer);
  }

  @Override
  public Customer findByEmail(final String email) {
    return customerRepository.findByEmail(email).stream().findFirst().orElse(null);
  }
}
