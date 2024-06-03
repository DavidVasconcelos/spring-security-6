package com.udemy.springsecuritysection13.security;

import static org.springframework.security.config.Customizer.withDefaults;

import com.udemy.springsecuritysection13.security.filter.AuthoritiesLoggingAfterFilter;
import com.udemy.springsecuritysection13.security.filter.AuthoritiesLoggingAtFilter;
import com.udemy.springsecuritysection13.security.filter.CsrfCookieFilter;
import com.udemy.springsecuritysection13.security.filter.JWTTokenGeneratorFilter;
import com.udemy.springsecuritysection13.security.filter.JWTValidatorFilter;
import com.udemy.springsecuritysection13.security.filter.RequestValidationBeforeFilter;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  @Profile("!local")
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    final CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
    requestHandler.setCsrfRequestAttributeName("_csrf");
    http
        .sessionManagement((sessionManagement) -> sessionManagement
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        )
        .cors(Customizer.withDefaults())
        .csrf((csrf) -> csrf
            .ignoringRequestMatchers("/contact", "/register")
            .csrfTokenRequestHandler(requestHandler)
            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
        )
        .addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
        .addFilterBefore(new JWTValidatorFilter(), BasicAuthenticationFilter.class)
        .addFilterAt(new AuthoritiesLoggingAtFilter(), BasicAuthenticationFilter.class)
        .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
        .addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class)
        .addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
        .authorizeHttpRequests((requests) -> requests
            .requestMatchers("/myAccount").hasRole("USER")
            .requestMatchers("/myBalance").hasAnyRole("USER","ADMIN")
            .requestMatchers("/myLoans").authenticated()
            .requestMatchers("/myCards").hasRole("USER")
            .requestMatchers("user").authenticated()
            .requestMatchers("/contact", "/notices", "/register").permitAll()
        )
        .formLogin(withDefaults())
        .httpBasic(withDefaults());
    return http.build();
  }

  @Bean
  @Profile("local")
  SecurityFilterChain localSecurityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll())
        .formLogin(withDefaults())
        .httpBasic(withDefaults());
    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public CorsFilter corsFilter() {
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    final CorsConfiguration config = new CorsConfiguration();
    config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
    config.setAllowedMethods(Collections.singletonList("*"));
    config.setAllowCredentials(true);
    config.setAllowedHeaders(Collections.singletonList("*"));
    config.setExposedHeaders(Collections.singletonList("Authorization"));
    config.setMaxAge(3600L);
    source.registerCorsConfiguration("/**", config);
    return new CorsFilter(source);
  }
}
