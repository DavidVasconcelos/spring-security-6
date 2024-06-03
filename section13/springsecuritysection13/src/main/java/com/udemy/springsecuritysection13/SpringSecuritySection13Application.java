package com.udemy.springsecuritysection13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity(securedEnabled = true)
public class SpringSecuritySection13Application {

  public static void main(String[] args) {
    SpringApplication.run(SpringSecuritySection13Application.class, args);
  }

}
