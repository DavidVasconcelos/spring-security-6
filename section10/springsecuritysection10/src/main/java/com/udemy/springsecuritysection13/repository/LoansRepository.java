package com.udemy.springsecuritysection13.repository;

import com.udemy.springsecuritysection13.model.Loans;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

@Repository
public interface LoansRepository extends CrudRepository<Loans, Integer> {

  @PreAuthorize("hasRole('USER')")
  List<Loans> findByCustomerIdOrderByStartDtDesc(Integer customerId);

}
