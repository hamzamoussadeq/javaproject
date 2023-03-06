package com.retail.user.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.retail.user.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	public UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(!userRepository.findByusername(username).isEmpty())
		{
			return new User(username,userRepository.findByusername(username).get(0).getPassword(),new ArrayList<>());
		}
		else
		{
			throw new UsernameNotFoundException("User not found !!");
		}
	}
	

}
