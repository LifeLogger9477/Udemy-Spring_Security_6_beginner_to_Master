package com.easybytes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author : ms.Lee
 * date   : 2024-01-29
 */
@RestController
public class CardsController {

  @GetMapping (value = "/myCards")
  public String getCardDetails() {

    return "Here are the card details from the DB";
  }
}
