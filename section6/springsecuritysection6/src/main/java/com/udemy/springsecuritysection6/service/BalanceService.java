package com.udemy.springsecuritysection6.service;

import com.udemy.springsecuritysection6.model.AccountTransactions;
import java.util.List;

public interface BalanceService {

  List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(Integer id);

}
