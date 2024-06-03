package com.udemy.springsecuritysection13.service.impl;

import com.udemy.springsecuritysection13.model.AccountTransactions;
import com.udemy.springsecuritysection13.model.Customer;
import com.udemy.springsecuritysection13.repository.AccountTransactionsRepository;
import com.udemy.springsecuritysection13.service.BalanceService;
import com.udemy.springsecuritysection13.service.UserService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl implements BalanceService {

  private final UserService userService;
  private final AccountTransactionsRepository accountTransactionsRepository;

  public BalanceServiceImpl(final UserService userService,
      final AccountTransactionsRepository accountTransactionsRepository) {
    this.userService = userService;
    this.accountTransactionsRepository = accountTransactionsRepository;
  }

  @Override
  public List<AccountTransactions> findByCustomerEmailOrderByTransactionDtDesc(final String email) {
    final Customer customer = userService.findByEmail(email);
    return accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(customer.getId());
  }
}
