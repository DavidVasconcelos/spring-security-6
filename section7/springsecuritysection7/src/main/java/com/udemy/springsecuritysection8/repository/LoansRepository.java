package com.udemy.springsecuritysection8.repository;

import com.udemy.springsecuritysection8.model.Loans;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoansRepository extends CrudRepository<Loans, Integer> {

  List<Loans> findByCustomerIdOrderByStartDtDesc(Integer customerId);

}
