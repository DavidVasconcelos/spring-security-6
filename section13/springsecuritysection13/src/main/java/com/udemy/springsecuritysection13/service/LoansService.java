package com.udemy.springsecuritysection13.service;

import com.udemy.springsecuritysection13.model.Loans;
import java.util.List;

public interface LoansService {

  List<Loans> findByCustomerEmailOrderByStartDtDesc(String email);

}
