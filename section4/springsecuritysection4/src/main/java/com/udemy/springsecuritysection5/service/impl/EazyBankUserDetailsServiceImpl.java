package com.udemy.springsecuritysection13.service.impl;

import com.udemy.springsecuritysection13.model.Customer;
import com.udemy.springsecuritysection13.repository.CustomerRepository;
import com.udemy.springsecuritysection13.service.EazyBankUserDetailsService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EazyBankUserDetailsServiceImpl implements EazyBankUserDetailsService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public EazyBankUserDetailsServiceImpl(final CustomerRepository customerRepository, final PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final List<Customer> customers = customerRepository.findByEmail(username);
        final Customer user = customers.stream().findFirst().orElseThrow(() ->
                new UsernameNotFoundException(STR."User details not found for the user : \{username}"));
        return new User(user.getEmail(), user.getPwd(), List.of(new SimpleGrantedAuthority(user.getRole())));
    }

    @Override
    public Customer save(final Customer customer) {
        final String hashPwd = passwordEncoder.encode(customer.getPwd());
        customer.setPwd(hashPwd);
        return customerRepository.save(customer);
    }
}
