package com.udemy.springsecuritysection9.repository;

import com.udemy.springsecuritysection9.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {


}