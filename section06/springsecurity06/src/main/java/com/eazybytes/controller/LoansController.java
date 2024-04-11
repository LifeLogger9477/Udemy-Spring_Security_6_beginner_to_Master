package com.eazybytes.controller;

import com.eazybytes.model.Loans;
import com.eazybytes.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author : ms.Lee
 * date   : 2024-01-29
 */
@RestController
public class LoansController {

  @Autowired
  private LoanRepository loanRepository;

  @GetMapping (value = "/myLoans")
  public List<Loans> getLoanDetails(@RequestParam int id) {

    List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc( id );

    if (loans != null) {

      return loans;
    }
    else {

      return null;
    }
  }
  /*
  public String getLoanDetails() {

    return "Here are the loan details from the DB";
  }

   */
}
