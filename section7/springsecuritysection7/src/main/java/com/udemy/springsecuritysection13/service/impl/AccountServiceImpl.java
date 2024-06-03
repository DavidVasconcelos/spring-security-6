package com.udemy.springsecuritysection13.service.impl;

import com.udemy.springsecuritysection13.model.Accounts;
import com.udemy.springsecuritysection13.repository.AccountsRepository;
import com.udemy.springsecuritysection13.service.AccountService;
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
