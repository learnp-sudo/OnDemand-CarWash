package com.green.car.wash.company.washer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.green.car.wash.company.washer.config.JwtUtil;
import com.green.car.wash.company.washer.model.AuthenticationRequest;
import com.green.car.wash.company.washer.model.AuthenticationResponse;
import com.green.car.wash.company.washer.model.MessageResponse;
import com.green.car.wash.company.washer.model.WasherProfile;
import com.green.car.wash.company.washer.repository.WasherRepository;
import com.green.car.wash.company.washer.service.MyUserDetailsService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/washers")
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtTokenUtil;
	@Autowired
	private WasherRepository repo;

	@PostMapping("/register")
	private ResponseEntity<?> subscribe(@Valid@RequestBody WasherProfile request)
	{
		if (repo.existsByUsername(request.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}


		String username = request.getUsername();
		String password = request.getPassword();
		String email=request.getEmail();
		String phoneNumber=request.getPhoneNunmber();
		String  fullName=request.getFullName();


		WasherProfile model = new WasherProfile();
		model.setUsername(username);
		model.setPassword(password);
		model.setEmail(email);
		model.setFullName(fullName);
		model.setPhoneNunmber(phoneNumber);

		try {
			repo.save(model);
		}
		catch (Exception e) {
			return ResponseEntity.ok(new AuthenticationResponse("Error while subsribing the user with username " + username));

		}
		    return ResponseEntity.ok(new AuthenticationResponse("client subscribed with username " + username));
	}
	@PostMapping("/login")
	//System.out.println("sreeja");
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		System.out.println("sreeja");
		try
		{
			System.out.println("sreeja");
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
	}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}


}



