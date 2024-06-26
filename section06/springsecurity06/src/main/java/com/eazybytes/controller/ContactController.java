package com.eazybytes.controller;

import com.eazybytes.model.Contact;
import com.eazybytes.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

/**
 * author : ms.Lee
 * date   : 2024-01-29
 */
@RestController
public class ContactController {

  @Autowired
  private ContactRepository contactRepository;

  @PostMapping ("/contact")
  public Contact saveContactInquiryDetails(@RequestBody Contact contact) {

    contact.setContactId( getServiceReqNumber() );
    contact.setCreateDt( new Date( System.currentTimeMillis() ) );

    return contactRepository.save(contact);
  }

  public String getServiceReqNumber() {

    Random random = new Random();

    int randNum = random.nextInt(999999999 - 9999) + 9999;

    return "SR" + randNum;
  }

  /*
  @GetMapping (value = "/contact")
  public String saveContactInquiryDetails() {

    return "Inquiry details are saved to the DB";
  }

   */
}
