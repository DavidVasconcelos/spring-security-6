package com.udemy.springsecuritysection13.repository;

import com.udemy.springsecuritysection13.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {


}