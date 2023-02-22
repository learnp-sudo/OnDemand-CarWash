package com.green.car.wash.company.admin.service;

import java.util.ArrayList;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.green.car.wash.company.admin.model.Admin;
import com.green.car.wash.company.admin.repository.UserRepo;
@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepo repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin =repo.findByUsername(username);
		if(admin==null)
		{
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		String name = admin.getUsername();
		String pwd = admin.getPassword();

		return new User(name, pwd, new ArrayList<>());

	}

}
