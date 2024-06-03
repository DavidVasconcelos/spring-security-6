package com.udemy.springsecuritysection13.service.impl;

import com.udemy.springsecuritysection13.model.Accounts;
import com.udemy.springsecuritysection13.model.Customer;
import com.udemy.springsecuritysection13.repository.AccountsRepository;
import com.udemy.springsecuritysection13.service.AccountService;
import com.udemy.springsecuritysection13.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

  private final UserService userService;
  private final AccountsRepository accountsRepository;


  public AccountServiceImpl(final UserService userService,
      final AccountsRepository accountsRepository) {
    this.userService = userService;
    this.accountsRepository = accountsRepository;
  }

  @Override
  public Accounts findByCustomerEmail(final String email) {
    final Customer customer = userService.findByEmail(email);
    return accountsRepository.findByCustomerId(customer.getId());
  }
}
