package com.udemy.springsecuritysection13.security.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

public class KeycloakConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

  @Override
  @SuppressWarnings({"unchecked", "preview"})
  public Collection<GrantedAuthority> convert(final Jwt jwt) {
    final Map<String, Object> realmAccess = (Map<String, Object>) jwt.getClaims()
        .get("realm_access");
    if(realmAccess == null || realmAccess.isEmpty()) {
      return new ArrayList<>();
    }
    return ((List<String>) realmAccess.get("roles"))
        .stream()
        .map(roleName -> STR."ROLE_\{roleName}")
        .map(SimpleGrantedAuthority::new)
        .collect(Collectors.toList());
  }
}
