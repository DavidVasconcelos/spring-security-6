package com.udemy.springsecuritysection9.service;

import com.udemy.springsecuritysection9.model.Accounts;

public interface AccountService {

  Accounts findByCustomerId(Integer id);
}
