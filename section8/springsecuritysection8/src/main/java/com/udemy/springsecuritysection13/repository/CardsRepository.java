package com.udemy.springsecuritysection13.repository;

import com.udemy.springsecuritysection13.model.Cards;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardsRepository extends CrudRepository<Cards, Integer> {

  List<Cards> findByCustomerId(Integer customerId);

}
