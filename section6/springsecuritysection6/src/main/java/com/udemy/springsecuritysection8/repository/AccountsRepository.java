package com.udemy.springsecuritysection8.repository;

import com.udemy.springsecuritysection8.model.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Integer> {

  Accounts findByCustomerId(Integer customerId);

}