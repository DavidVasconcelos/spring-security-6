package com.udemy.springsecuritysection13.service.impl;

import com.udemy.springsecuritysection13.model.Cards;
import com.udemy.springsecuritysection13.repository.CardsRepository;
import com.udemy.springsecuritysection13.service.CardsService;
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
