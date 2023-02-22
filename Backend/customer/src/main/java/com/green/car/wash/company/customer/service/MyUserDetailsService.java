package com.green.car.wash.company.customer.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.green.car.wash.company.customer.models.customerDetails;
import com.green.car.wash.company.customer.repository.CustomerRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	CustomerRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		customerDetails customer = repo.findByUsername(username);
		if (customer == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		String name = customer.getUsername();
		String pwd = customer.getPassword();

		return new User(name, pwd, new ArrayList<>());

	}

}
