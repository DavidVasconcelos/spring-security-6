package com.udemy.SpringSecOauth2GitHubApplication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecOAUTH2GitHubConfig {

//  @Value("${oauth2.client-id}")
//  private String clientId;
//  @Value("${oauth2.client-secret}")
//  private String clientSecret;

  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated())
        .oauth2Login(Customizer.withDefaults());
    return http.build();
  }

//  Will be auto config with the new values on properties file

//  @Bean
//  public ClientRegistrationRepository clientRepository() {
//    ClientRegistration clientReg = clientRegistration();
//    return new InMemoryClientRegistrationRepository(clientReg);
//  }
//
//  private ClientRegistration clientRegistration() {
//    return CommonOAuth2Provider.GITHUB
//        .getBuilder("github")
//        .clientId(clientId)
//        .clientSecret(clientSecret)
//        .build();
//  }
}
