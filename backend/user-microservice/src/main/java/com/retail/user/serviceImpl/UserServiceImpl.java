package com.retail.user.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.retail.user.exception.UserNotFoundException;
import com.retail.user.model.User;
import com.retail.user.repository.UserRepository;
import com.retail.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public BCryptPasswordEncoder bCryptPasswordEncoder;
	
//	private static final String USERNAME_STRING = "^[a-zA-Z]*$";
	
	public User saveUser(User user) throws Exception {
		try {
			String phoneNo = user.getPhoneNo();
			User existingUser = userRepository.findByPhoneNo(phoneNo);
			System.out.println(existingUser);
			System.out.println(existingUser == null);
			if(existingUser == null) {
				user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
				return userRepository.save(user);
			} else {
				throw new Exception("already exists");
			}
		}
			catch(Exception e) {
				throw new Exception("No user found");
			}
		
	}		
	public List<User> fetchUserList(){
		return userRepository.findAll();
	}
	public User fetchUserById(int id)  throws UserNotFoundException
    {
    	Optional<User> user = userRepository.findById(id);
    	if (!user.isPresent()) {
    		throw new UserNotFoundException("User not found with Id : "+id);
			
		}
    	return user.get();
    }
    public void deleteUserById(int id)
    {
    	userRepository.deleteById(id);
    }
    public User updateUser( int id, User user)
    {
    	User patDB = userRepository.findById(id).get();
    	if(Objects.nonNull(user.getUsername())&&
    			!"".equalsIgnoreCase(user.getUsername()))
    	{
    		patDB.setUsername(user.getUsername());
    	}
    	if(Objects.nonNull(user.getPassword())&&
    			!"".equalsIgnoreCase(user.getPassword()))
    	{
    		patDB.setPassword(user.getPassword());
    	}
    	if(Objects.nonNull(user.getAddress())&&
    			!"".equalsIgnoreCase(user.getAddress()))
    	{
    		patDB.setAddress(user.getAddress());;
    	}
    	if(Objects.nonNull(user.getPhoneNo())&&
    			!"".equalsIgnoreCase(user.getPhoneNo()))
    	{
    		patDB.setPhoneNo(user.getPhoneNo());;
    	}
    	return userRepository.save(patDB);
    }

	@Override
	public List<User> fetchByusername(String username) {
		return userRepository.findByusername(username);
	}
	@Override
	public List<User> findByusername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User loginUser(User user) {
		// TODO Auto-generated method stub
		User checkUser=userRepository.findByUsername(user.getUsername());
		if(bCryptPasswordEncoder.matches(user.getPassword(), checkUser.getPassword())) {
			return checkUser;
		}
		else {
			return null;
		}
	}


}
