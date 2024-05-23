package com.udemy.springsecuritysection10.controller;

import com.udemy.springsecuritysection10.model.Contact;
import com.udemy.springsecuritysection10.service.ContactService;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import org.apache.coyote.BadRequestException;
import org.springframework.security.access.prepost.PreFilter;
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
  @PreFilter("filterObject.contactName != 'Test'")
  public List<Contact> saveContactInquiryDetails(@RequestBody List<Contact> contacts) // need to be a list to filter work properly
      throws BadRequestException {
    final Contact contact = contacts.stream().findFirst()
        .orElseThrow(() -> new BadRequestException("Request without contact"));
    contact.setContactId(getServiceReqNumber());
    contact.setCreateDt(LocalDate.now());
    return List.of(contactService.save(contact));
  }

  private  String getServiceReqNumber() {
    final Random random = new Random();
    final int ranNum = random.nextInt(999999999 - 9999) + 9999;
    return STR."SR\{ranNum}";
  }
}
