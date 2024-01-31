package com.eazybytes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EnableWebSecurity => SpringBootApplication 이므로 사용하지 않아도 됨
// 하위 package에 설정하지 않았다면 아래 2개의 annotation을 사용한다.
//--> 지금 사용하지 않음
// @EnableJpaRepositories("com.eazybytes.repository")
// @EntityScan("com.eazybytes.model")
public class EazyBankBackendApplication {

  public static void main(String[] args) {

    SpringApplication.run( EazyBankBackendApplication.class, args );
  }

}
