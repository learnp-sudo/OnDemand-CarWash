package com.green.car.wash.company.washer.service;

import java.util.ArrayList;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.green.car.wash.company.washer.model.WasherProfile;
import com.green.car.wash.company.washer.repository.WasherRepository;
@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
     WasherRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		WasherProfile washer =repo.findByUsername(username);
		if(washer==null)
		{
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		String name = washer.getUsername();
		String pwd = washer.getPassword();

		return new User(name, pwd, new ArrayList<>());

	}

}
