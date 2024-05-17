package com.udemy.springsecuritysection7.repository;

import com.udemy.springsecuritysection7.model.AccountTransactions;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransactionsRepository extends CrudRepository<AccountTransactions, Integer> {

  List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(Integer customerId);

}