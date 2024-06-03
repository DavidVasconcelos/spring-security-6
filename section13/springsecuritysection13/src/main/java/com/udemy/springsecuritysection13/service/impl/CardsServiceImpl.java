package com.udemy.springsecuritysection13.service.impl;

import com.udemy.springsecuritysection13.model.Cards;
import com.udemy.springsecuritysection13.model.Customer;
import com.udemy.springsecuritysection13.repository.CardsRepository;
import com.udemy.springsecuritysection13.service.CardsService;
import com.udemy.springsecuritysection13.service.UserService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CardsServiceImpl implements CardsService {

  private final UserService userService;
  private final CardsRepository cardsRepository;

  public CardsServiceImpl(final UserService userService, final CardsRepository cardsRepository) {
    this.userService = userService;
    this.cardsRepository = cardsRepository;
  }

  @Override
  public List<Cards> findByCustomerEmail(final String email) {
    final Customer customer = userService.findByEmail(email);
    return cardsRepository.findByCustomerId(customer.getId());
  }
}
