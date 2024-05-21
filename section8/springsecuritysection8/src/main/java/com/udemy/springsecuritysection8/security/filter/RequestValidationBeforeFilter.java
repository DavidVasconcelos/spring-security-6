package com.udemy.springsecuritysection8.security.filter;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.util.StringUtils;

public class RequestValidationBeforeFilter implements Filter {

  public final String AUTHENTICATION_SCHEME_BASIC = "Basic";
  private final Charset credentialsCharset = StandardCharsets.UTF_8;

  @Override
  public void doFilter(final ServletRequest request, final ServletResponse response,
      final FilterChain chain)
      throws IOException, ServletException {
    final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    final HttpServletResponse httpServletResponse = (HttpServletResponse) response;
    final String header = httpServletRequest.getHeader(AUTHORIZATION);
    if (header != null) {
      final String trimmedHeader = header.trim();
      if (StringUtils.startsWithIgnoreCase(trimmedHeader, AUTHENTICATION_SCHEME_BASIC)) {
        final byte[] base64Token = trimmedHeader.substring(6).getBytes(StandardCharsets.UTF_8);
        try {
          final byte[] decoded = Base64.getDecoder().decode(base64Token);
          final String token = new String(decoded, credentialsCharset);
          final int delimiter = token.indexOf(":");
          if (delimiter == -1) {
            throw new BadCredentialsException("Invalid basic authentication token");
          }
          final String email = token.substring(0, delimiter);
          if (email.toLowerCase().contains("test")) {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
          }
        } catch (IllegalArgumentException e) {
          throw new BadCredentialsException("Failed to decode basic authentication token");
        }
      }
    }
    chain.doFilter(request, response);
  }
}
