package com.green.car.wash.company.customer.controller;



import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.green.car.wash.company.customer.cofig.JwtUtil;
import com.green.car.wash.company.customer.models.AuthenticationRequest;
import com.green.car.wash.company.customer.models.AuthenticationResponse;
import com.green.car.wash.company.customer.models.MessageResponse;
import com.green.car.wash.company.customer.models.customerDetails;
import com.green.car.wash.company.customer.repository.CustomerRepo;
import com.green.car.wash.company.customer.service.MyUserDetailsService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/customer")
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtTokenUtil;
	@Autowired
	private CustomerRepo repo;

Logger log = LoggerFactory.getLogger(AuthController.class);

	@PostMapping("/register")
	private ResponseEntity<?> subscribe(@Valid@RequestBody customerDetails request)
	{
		if (repo.existsByUsername(request.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}


		String username = request.getUsername();
		String password = request.getPassword();
		String email=request.getEmail();
		String phoneNumber=request.getPhoneNumber();
		String fullName=request.getFullName();


		customerDetails model = new customerDetails();
		model.setUsername(username);
		model.setPassword(password);
		model.setEmail(email);
		model.setPhoneNumber(phoneNumber);
		model.setFullName(fullName);
		try {
			log.info("details saved");
			repo.save(model);
		}
		catch (Exception e) {
			log.error("data not inserted");
			return ResponseEntity.ok(new AuthenticationResponse("Error while subsribing the user with username " + username));

		}
		    return ResponseEntity.ok(new AuthenticationResponse("client subscribed with username " + username));
	}

	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try
		{
			log.info("authenticate");
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
	}
		catch (BadCredentialsException e) {
			log.info("user not found");
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		log.info("jwt");

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}


}



