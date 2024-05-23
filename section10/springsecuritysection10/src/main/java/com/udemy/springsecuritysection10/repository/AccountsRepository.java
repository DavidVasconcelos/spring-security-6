package com.udemy.springsecuritysection10.repository;

import com.udemy.springsecuritysection10.model.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Integer> {

  Accounts findByCustomerId(Integer customerId);

}