package com.udemy.springsecuritysection10.repository;

import com.udemy.springsecuritysection10.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {


}