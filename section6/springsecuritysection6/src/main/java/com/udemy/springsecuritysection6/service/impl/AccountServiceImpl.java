package com.udemy.springsecuritysection6.service.impl;

import com.udemy.springsecuritysection6.model.Accounts;
import com.udemy.springsecuritysection6.repository.AccountsRepository;
import com.udemy.springsecuritysection6.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

  private final AccountsRepository accountsRepository;

  public AccountServiceImpl(final AccountsRepository accountsRepository) {
    this.accountsRepository = accountsRepository;
  }

  @Override
  public Accounts findByCustomerId(final Integer id) {
    return accountsRepository.findByCustomerId(id);
  }
}
