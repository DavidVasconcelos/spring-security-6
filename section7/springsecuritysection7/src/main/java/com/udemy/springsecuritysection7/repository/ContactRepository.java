package com.udemy.springsecuritysection7.repository;

import com.udemy.springsecuritysection7.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {


}