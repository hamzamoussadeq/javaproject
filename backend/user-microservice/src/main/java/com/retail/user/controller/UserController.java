package com.retail.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.retail.user.exception.UserNotFoundException;
import com.retail.user.model.User;
import com.retail.user.serviceImpl.UserServiceImpl;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserServiceImpl userService;

//	private static final String USERNAME_STRING = "^[a-zA-Z]*$";

	@PostMapping("/usersadd") // Create user Details
	public User saveUser(@RequestBody @Valid User user) throws Exception {
		return userService.saveUser(user);
	}

	@PostMapping("/loginuser")
	public User loginUser(@RequestBody User user) {
		return userService.loginUser(user);
	}

	@GetMapping("/Getuser") // Get User Details
	public List<User> fetchUserList() {
		return userService.fetchUserList();
	}

	@GetMapping("/user/{id}") // Get user Details by userId
	public User fetchUserByID(@PathVariable("id") String id) throws UserNotFoundException {
		return userService.fetchUserById(Integer.parseInt(id));

	}

	@DeleteMapping("/user/{id}") // Delete user details by userId
	public String deleteUserById(@PathVariable("id") int id) {
		userService.deleteUserById(id);
		return "Deleted user successfully";
	}

	@PutMapping("/user/{id}") // update user details by UserID
	public User updateUser(@PathVariable("id") int id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}

	@GetMapping("/users/name/{name}") // Get User Details by User Name
	public List<User> fetchByusername(@PathVariable("name") String username) {
		return userService.fetchByusername(username);
	}

	public String exceptionHanderNull() {
		return "null";
	}

//	@PostMapping("/BookAppointment")
//	public boolean bookAppointment(@RequestBody appointmentData Data) {
////    	Data.setPatientname(token);
//
////    	String token = request.getHeader("Authorization").split(" ")[1].trim();
////    	Data.setPatientname(Util.extractUsername(token));
//		return restTemp.getForObject(
//				"http://localhost:9093/appoint/" + Data.getPatientname() + "/" + Data.getDoctorname() + "/"
//						+ Data.getAppointmentDate() + "/" + Data.getAppointmentType() + "/" + Data.getConformation(),
//				Boolean.class);
//	}

}
