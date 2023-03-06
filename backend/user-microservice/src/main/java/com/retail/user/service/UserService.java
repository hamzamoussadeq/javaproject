package com.retail.user.service;

import java.util.List;

import com.retail.user.exception.UserNotFoundException;
import com.retail.user.model.User;

public interface UserService {
	
	public User saveUser(User user) throws Exception;
	public List<User> fetchUserList();
	public User fetchUserById(int id) throws UserNotFoundException;
	public void deleteUserById(int id);
	public  User updateUser(int id, User user);
	public List<User> fetchByusername(String username);
	List<User> findByusername(String username);
	public User loginUser(User user);
}
