package com.udemy.springsecuritysection9.service.impl;

import com.udemy.springsecuritysection9.model.AccountTransactions;
import com.udemy.springsecuritysection9.repository.AccountTransactionsRepository;
import com.udemy.springsecuritysection9.service.BalanceService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl implements BalanceService {

  private final AccountTransactionsRepository accountTransactionsRepository;

  public BalanceServiceImpl(final AccountTransactionsRepository accountTransactionsRepository) {
    this.accountTransactionsRepository = accountTransactionsRepository;
  }

  @Override
  public List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(final Integer id) {
    return accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(id);
  }
}