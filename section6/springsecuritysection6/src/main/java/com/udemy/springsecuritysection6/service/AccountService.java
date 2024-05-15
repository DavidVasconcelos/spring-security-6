package com.udemy.springsecuritysection6.service;

import com.udemy.springsecuritysection6.model.Accounts;

public interface AccountService {

  Accounts findByCustomerId(Integer id);
}
