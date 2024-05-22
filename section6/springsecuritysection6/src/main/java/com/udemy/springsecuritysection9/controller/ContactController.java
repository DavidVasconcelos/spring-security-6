package com.udemy.springsecuritysection9.controller;

import com.udemy.springsecuritysection9.model.Contact;
import com.udemy.springsecuritysection9.service.ContactService;
import java.time.LocalDate;
import java.util.Random;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

  private final ContactService contactService;

  public ContactController(final ContactService contactService) {
    this.contactService = contactService;
  }

  @PostMapping("/contact")
  public Contact saveContactInquiryDetails(@RequestBody Contact contact) {
    contact.setContactId(getServiceReqNumber());
    contact.setCreateDt(LocalDate.now());
    return contactService.save(contact);
  }

  private  String getServiceReqNumber() {
    final Random random = new Random();
    final int ranNum = random.nextInt(999999999 - 9999) + 9999;
    return STR."SR\{ranNum}";
  }
}
