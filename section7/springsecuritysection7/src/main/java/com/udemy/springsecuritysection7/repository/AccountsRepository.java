package com.udemy.springsecuritysection7.repository;

import com.udemy.springsecuritysection7.model.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Integer> {

  Accounts findByCustomerId(Integer customerId);

}