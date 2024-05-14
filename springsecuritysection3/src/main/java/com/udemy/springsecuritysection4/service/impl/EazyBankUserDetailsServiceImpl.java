package com.udemy.springsecuritysection4.service.impl;

import com.udemy.springsecuritysection4.model.Customer;
import com.udemy.springsecuritysection4.repository.CustomerRepository;
import com.udemy.springsecuritysection4.service.EazyBankUserDetailsService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EazyBankUserDetailsServiceImpl implements EazyBankUserDetailsService {

    private final CustomerRepository customerRepository;

    public EazyBankUserDetailsServiceImpl(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
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
        return customerRepository.save(customer);
    }
}
