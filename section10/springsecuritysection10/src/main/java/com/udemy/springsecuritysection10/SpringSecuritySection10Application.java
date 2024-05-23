package com.udemy.springsecuritysection10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity(securedEnabled = true)
public class SpringSecuritySection10Application {

  public static void main(String[] args) {
    SpringApplication.run(SpringSecuritySection10Application.class, args);
  }

}
