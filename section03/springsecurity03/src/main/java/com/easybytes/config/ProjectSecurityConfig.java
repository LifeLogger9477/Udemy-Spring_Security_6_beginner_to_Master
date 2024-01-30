package com.easybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * author : ms.Lee
 * date   : 2024-01-29
 */
@Configuration
public class ProjectSecurityConfig {

  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
      throws Exception {

    http.authorizeHttpRequests(
            (requests) -> requests
                .requestMatchers(
                    "/myAccount",
                    "/myBalance",
                    "/myLoans",
                    "/myCards" ).authenticated()
                .requestMatchers(
                    "/notices",
                    "/contact" ).permitAll()
        )
        .formLogin( Customizer.withDefaults() )
        .httpBasic( Customizer.withDefaults() );

    return http.build();
  }

  @Bean
  public InMemoryUserDetailsManager userDetailsService() {

    /*
    Approach 1 where we use withDefaultPasswordEncoder() method
    while creating the user details
     */

    // 암호를 plain-text로 사용하려고 withDefaultPasswordEncoder() 사용
    /*
    UserDetails admin = User.withDefaultPasswordEncoder()
        .username( "admin" )
        .password( "12345" )
        .authorities( "admin" )
        .build();

    UserDetails user = User.withDefaultPasswordEncoder()
        .username( "user" )
        .password( "12345" )
        .authorities( "read" )
        .build();

    return new InMemoryUserDetailsManager( admin, user );
    */


    /*
    Approach 2 where we use NoOpPasswordEncoder Bean
    while creating the user details
     */

    UserDetails admin = User.withUsername( "admin" )
        .password( "12345" )
        .authorities( "admin" )
        .build();

    UserDetails user = User.withUsername( "user" )
        .password( "12345" )
        .authorities( "read" )
        .build();

    return new InMemoryUserDetailsManager( admin, user );
  }

  /**
   * NoOpPasswordEncoder is not recommended for production usage.
   * Use only for non-prod
   *
   * @return PasswordEncoder
   */
  @Bean
  public PasswordEncoder passwordEncoder() {

    // 보안상 비추
    return NoOpPasswordEncoder.getInstance();
  }
}
