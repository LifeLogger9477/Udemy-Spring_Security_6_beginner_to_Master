package com.eazybytes.controller;

import com.eazybytes.model.Accounts;
import com.eazybytes.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * author : ms.Lee
 * date   : 2024-01-29
 */
@RestController
public class AccountController {

  @Autowired
  private AccountRepository accountRepository;

  @GetMapping (value = "/myAccount")
  private Accounts getAccountDetails(@RequestParam int id) {

    Accounts accounts = accountRepository.findByCustomerId( id );
    if (accounts != null) {

      return accounts;
    }
    else {

      return null;
    }
  }

  /*
  public String getAccountDetails() {

    return "Here are the account details form the DB";
  }
   */
}
