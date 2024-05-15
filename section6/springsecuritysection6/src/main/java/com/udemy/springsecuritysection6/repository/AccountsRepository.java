package com.udemy.springsecuritysection6.repository;

import com.udemy.springsecuritysection6.model.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Integer> {

  Accounts findByCustomerId(Integer customerId);

}