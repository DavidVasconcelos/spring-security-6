package com.udemy.springsecuritysection10.service.impl;

import com.udemy.springsecuritysection10.model.Cards;
import com.udemy.springsecuritysection10.repository.CardsRepository;
import com.udemy.springsecuritysection10.service.CardsService;
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
