package com.eazybytes.controller;

import com.eazybytes.model.Cards;
import com.eazybytes.repository.CardsRepository;
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
public class CardsController {

  @Autowired
  private CardsRepository cardsRepository;

  @GetMapping (value = "/myCards")
  public List<Cards> getCardDetails(@RequestParam int id) {

    List<Cards> cards = cardsRepository.findByCustomerId( id );
    if (cards != null) {

      return cards;
    }
    else {

      return null;
    }
  }
  /*
  public String getCardDetails() {

    return "Here are the card details from the DB";
  }

   */
}
