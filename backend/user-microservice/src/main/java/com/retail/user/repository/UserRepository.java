package com.retail.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retail.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public List<User> findByusername(String username);
	public User findByusernameIgnoreCase(String username);
	public User findByPhoneNo(String phoneNo);
	public User findByUsername(String username);
	
}
