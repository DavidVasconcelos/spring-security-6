package com.udemy.springsecuritysection10.repository;

import com.udemy.springsecuritysection10.model.Cards;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardsRepository extends CrudRepository<Cards, Integer> {

  List<Cards> findByCustomerId(Integer customerId);

}