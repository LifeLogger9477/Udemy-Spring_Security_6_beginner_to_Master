package com.eazybytes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author : ms.Lee
 * date   : 2024-01-29
 */
@RestController
public class ContactController {

  @GetMapping (value = "/contact")
  public String saveContactInquiryDetails() {

    return "Inquiry details are saved to the DB";
  }
}
