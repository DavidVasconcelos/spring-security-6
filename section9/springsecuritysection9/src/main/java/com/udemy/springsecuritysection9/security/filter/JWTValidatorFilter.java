package com.udemy.springsecuritysection9.security.filter;

import com.udemy.springsecuritysection9.constant.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;
import javax.crypto.SecretKey;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class JWTValidatorFilter extends OncePerRequestFilter {

  final Logger LOG = Logger.getLogger(this.getClass().getName());

  @Override
  protected void doFilterInternal(final HttpServletRequest request,
      final HttpServletResponse response, final FilterChain filterChain)
      throws ServletException, IOException {
    try {
      final String jwt = request.getHeader(SecurityConstants.JWT_HEADER);
      final SecretKey key = Keys.hmacShaKeyFor(
          SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
      final Claims claims = Jwts.parser()
          .verifyWith(key)
          .build()
          .parseSignedClaims(jwt)
          .getPayload();
      final String username = String.valueOf(claims.get("username"));
      final String authorities = String.valueOf(claims.get("authorities"));
      final UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
          username, null, AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
      SecurityContextHolder.getContext().setAuthentication(authenticationToken);
      filterChain.doFilter(request, response);
    } catch (RuntimeException ex) {
      LOG.severe(ex.getMessage());
      throw new BadCredentialsException("Invalid Token received!");
    }
  }

  @Override
  protected boolean shouldNotFilter(final HttpServletRequest request) {
    return request.getServletPath().equals("/user");
  }
}
