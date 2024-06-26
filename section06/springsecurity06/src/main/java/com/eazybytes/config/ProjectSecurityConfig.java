package com.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    http
        .csrf( csrf -> csrf.disable())
        .authorizeHttpRequests(
            (requests) -> requests
                .requestMatchers(
                    "/myAccount",
                    "/myBalance",
                    "/myLoans",
                    "/myCards",
                    "/user").authenticated()
                .requestMatchers(
                    "/notices",
                    "/contact",
                    "/register" ).permitAll()
        )
        .formLogin( Customizer.withDefaults() )
        .httpBasic( Customizer.withDefaults() );

    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {

    return new BCryptPasswordEncoder();
  }
}
