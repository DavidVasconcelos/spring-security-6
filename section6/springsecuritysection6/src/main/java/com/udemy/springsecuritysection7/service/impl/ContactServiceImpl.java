package com.udemy.springsecuritysection7.service.impl;

import com.udemy.springsecuritysection7.model.Contact;
import com.udemy.springsecuritysection7.repository.ContactRepository;
import com.udemy.springsecuritysection7.service.ContactService;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

  private final ContactRepository contactRepository;

  public ContactServiceImpl(final ContactRepository contactRepository) {
    this.contactRepository = contactRepository;
  }

  @Override
  public Contact save(final Contact contact) {
    return contactRepository.save(contact);
  }
}
