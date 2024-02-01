package com.eazybytes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author : ms.Lee
 * date   : 2024-01-29
 */
@RestController
public class AccountController {

  @GetMapping (value = "/myAccount")
  public String getAccountDetails() {

    return "Here are the account details form the DB";
  }
}
