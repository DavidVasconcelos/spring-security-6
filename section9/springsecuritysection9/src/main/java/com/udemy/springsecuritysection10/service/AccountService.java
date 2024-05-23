package com.udemy.springsecuritysection10.service;

import com.udemy.springsecuritysection10.model.Accounts;

public interface AccountService {

  Accounts findByCustomerId(Integer id);
}
