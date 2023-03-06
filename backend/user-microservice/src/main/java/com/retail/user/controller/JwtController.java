package com.retail.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.retail.user.helper.JwtUtil;
import com.retail.user.model.JwtUsername;
import com.retail.user.serviceImpl.CustomUserDetailsService;
import com.retail.user.utility.JwtRequest;
import com.retail.user.utility.JwtResponse;

@RestController
@CrossOrigin
public class JwtController {
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;

	@RequestMapping(value = "/token", method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		System.out.println(jwtRequest);
		try {
			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));

		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		} catch (BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}
		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtil.generateToken(userDetails);
		System.out.println("JWT" + token);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	@PostMapping("/user/token/get")
	public ResponseEntity<?> getUsername(@RequestBody String token) {
		String username = jwtUtil.extractUsername(token);
		return ResponseEntity.ok(new JwtUsername(username));
	}

}
