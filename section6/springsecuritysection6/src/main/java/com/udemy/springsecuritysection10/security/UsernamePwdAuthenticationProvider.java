package com.udemy.springsecuritysection10.security;

import com.udemy.springsecuritysection10.exception.InvalidPasswordException;
import com.udemy.springsecuritysection10.model.Customer;
import com.udemy.springsecuritysection10.repository.CustomerRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsernamePwdAuthenticationProvider implements AuthenticationProvider {

  private final Logger log = LoggerFactory.getLogger(this.getClass());

  private final CustomerRepository customerRepository;
  private final PasswordEncoder passwordEncoder;

  public UsernamePwdAuthenticationProvider(final CustomerRepository customerRepository,
      final PasswordEncoder passwordEncoder) {
    this.customerRepository = customerRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public Authentication authenticate(final Authentication authentication)
      throws AuthenticationException {
    try {
      final String username = authentication.getName();
      final UserDetails userDetails = this.loadUserByUsername(username);
      final String pwd = authentication.getCredentials().toString();
      if (!passwordEncoder.matches(pwd, userDetails.getPassword())) {
        throw new InvalidPasswordException();
      }
      return new UsernamePasswordAuthenticationToken(userDetails, pwd,
          userDetails.getAuthorities());
    } catch (UsernameNotFoundException | InvalidPasswordException exception) {
      log.info(exception.getMessage());
      throw new BadCredentialsException("Invalid username or password");
    }
  }

  @Override
  public boolean supports(final Class<?> authentication) {
    return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(
        authentication)); // From DaoAuthenticationProvider
  }

  private UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
    final List<Customer> customers = customerRepository.findByEmail(username);
    final Customer user = customers.stream().findFirst().orElseThrow(() ->
        new UsernameNotFoundException(STR."User details not found for the user : \{username}"));
    return new User(user.getEmail(), user.getPwd(),
        List.of(new SimpleGrantedAuthority(user.getRole())));
  }
}
