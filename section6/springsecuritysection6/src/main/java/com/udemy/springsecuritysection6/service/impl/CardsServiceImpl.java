package com.udemy.springsecuritysection6.service.impl;

import com.udemy.springsecuritysection6.model.Cards;
import com.udemy.springsecuritysection6.repository.CardsRepository;
import com.udemy.springsecuritysection6.service.CardsService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CardsServiceImpl implements CardsService {

  private final CardsRepository cardsRepository;

  public CardsServiceImpl(final CardsRepository cardsRepository) {
    this.cardsRepository = cardsRepository;
  }

  @Override
  public List<Cards> findByCustomerId(final Integer id) {
    return cardsRepository.findByCustomerId(id);
  }
}
