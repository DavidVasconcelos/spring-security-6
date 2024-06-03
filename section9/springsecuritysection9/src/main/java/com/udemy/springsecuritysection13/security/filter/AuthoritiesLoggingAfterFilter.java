package com.udemy.springsecuritysection13.security.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.util.logging.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthoritiesLoggingAfterFilter implements Filter {

  final Logger LOG = Logger.getLogger(this.getClass().getName());

  @Override
  public void doFilter(final ServletRequest request, final ServletResponse response,
      final FilterChain chain)
      throws IOException, ServletException {
    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if(null != authentication) {
      LOG.info(STR."User \{authentication.getName()} is successfully authenticated and has" +
          STR." authorities \{authentication.getAuthorities().toString()}");
    }
    chain.doFilter(request, response);
  }
}
