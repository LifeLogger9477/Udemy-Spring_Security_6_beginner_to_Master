package com.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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

    /**
     * Below is the custom security configurations
     */

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

    /**
     * Configurations to deny all the requests
     * 참고용
     * Not Recommended for Production
     */

    /*
    http.authorizeHttpRequests(
            (requests) -> requests.anyRequest().denyAll()
        )
        .formLogin( Customizer.withDefaults() )
        .httpBasic( Customizer.withDefaults() );

    return http.build();
    */

    /**
     * Configurations to permit all the requests
     * 참고용
     * Not Recommended for Production
     */

    /*
    http.authorizeHttpRequests(
            (requests) -> requests.anyRequest().permitAll()
        )
        .formLogin( Customizer.withDefaults() )
        .httpBasic( Customizer.withDefaults() );

    return http.build();
    */
  }
}
