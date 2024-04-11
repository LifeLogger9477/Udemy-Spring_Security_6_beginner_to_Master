package com.eazybytes.repository;

import com.eazybytes.model.Cards;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author : ms.Lee
 * date   : 2024-04-11
 */
@Repository
public interface CardsRepository extends CrudRepository<Cards, Long> {

  List<Cards> findByCustomerId(int customerId);
}
