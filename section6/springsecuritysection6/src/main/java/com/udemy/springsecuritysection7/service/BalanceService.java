package com.udemy.springsecuritysection7.service;

import com.udemy.springsecuritysection7.model.AccountTransactions;
import java.util.List;

public interface BalanceService {

  List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(Integer id);

}
