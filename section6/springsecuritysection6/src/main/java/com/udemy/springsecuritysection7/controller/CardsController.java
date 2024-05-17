package com.udemy.springsecuritysection7.controller;

import com.udemy.springsecuritysection7.model.Cards;
import com.udemy.springsecuritysection7.service.CardsService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

  private final CardsService cardsService;

  public CardsController(final CardsService cardsService) {
    this.cardsService = cardsService;
  }

  @GetMapping("/myCards")
  public List<Cards> getCardDetails(@RequestParam Integer id) {
    return cardsService.findByCustomerId(id);
  }
}
