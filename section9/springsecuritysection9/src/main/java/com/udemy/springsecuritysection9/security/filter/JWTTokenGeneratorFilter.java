package com.udemy.springsecuritysection9.security.filter;

import com.udemy.springsecuritysection9.constant.SecurityConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.stream.Collectors;
import javax.crypto.SecretKey;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class JWTTokenGeneratorFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(final HttpServletRequest request,
      final HttpServletResponse response, final FilterChain filterChain)
      throws ServletException, IOException {
    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (null != authentication) {
      final SecretKey key = Keys.hmacShaKeyFor(
          SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
      final String jwt = Jwts.builder()
          .issuer("Eazy Bank")
          .subject("JWT Token")
          .claim("username", authentication.getName())
          .claim("authorities", populateAuthorities(authentication.getAuthorities()))
          .issuedAt(new Date(System.currentTimeMillis()))
          .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 8)) // 8 hours
          .signWith(key).compact();
      response.setHeader(SecurityConstants.JWT_HEADER, jwt);
    }
    filterChain.doFilter(request, response);
  }

  @Override
  protected boolean shouldNotFilter(final HttpServletRequest request) {
    return !request.getServletPath().equals("/user");
  }

  private String populateAuthorities(final Collection<? extends GrantedAuthority> collection) {
    return new HashSet<GrantedAuthority>(collection)
        .stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.joining(","));
  }
}
