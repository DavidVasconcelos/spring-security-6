package com.udemy.springsecuritysection13.service;

import com.udemy.springsecuritysection13.model.AccountTransactions;
import java.util.List;

public interface BalanceService {

  List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(Integer id);

}
