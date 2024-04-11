package com.eazybytes.controller;

import com.eazybytes.model.Customer;
import com.eazybytes.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * author : ms.Lee
 * date   : 2024-01-31
 */
@RestController
public class LoginController {

  @Autowired
  CustomerRepository customerRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @PostMapping (value = "/register")
  public ResponseEntity<String> registerUser(@RequestBody Customer customer) {

    Customer savedCustomer = null;
    ResponseEntity response = null;

    try {

      String hashPwd = passwordEncoder.encode( customer.getPwd() );
      customer.setPwd( hashPwd );
      customer.setCreateDt(
          String.valueOf( new Date( System.currentTimeMillis() ) )
      );
      savedCustomer = customerRepository.save( customer );

      if (savedCustomer.getId() > 0) {

        response = ResponseEntity
            .status( HttpStatus.CREATED )
            .body( "Given user details are successfully registered" );
      }
    }
    catch (Exception e) {

      response = ResponseEntity
          .status( HttpStatus.INTERNAL_SERVER_ERROR )
          .body( "An exception occured due to " + e.getMessage() );
    }

    return response;

    /*
    try {

      String hashPwd = passwordEncoder.encode( customer.getPwd() );
      customer.setPwd( hashPwd );

      savedCustomer = customerRepository.save( customer );
      if (savedCustomer.getId() > 0) {

        response = ResponseEntity
            .status( HttpStatus.CREATED )
            .body( "Given user details are successfully registered" );
      }
    }
    catch (Exception ex) {

      response = ResponseEntity
          .status( HttpStatus.INTERNAL_SERVER_ERROR )
          .body( "An exception occurred due to " + ex.getMessage() );
    }

    return response;

     */
  }

  @RequestMapping (value = "/user")
  public Customer getuserDetailsAfterLogin(Authentication authentication) {

    List<Customer> customers =
        customerRepository.findByEmail( authentication.getName() );

    if (customers.size() > 0) {

      return customers.get( 0 );
    }
    else {

      return null;
    }
  }
}
