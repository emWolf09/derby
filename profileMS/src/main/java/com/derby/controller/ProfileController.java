package com.derby.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.derby.model.User;
import com.derby.service.UserService;

/**
 * @author MAHESH NAGARWAL
 *
 */

@RestController
@RequestMapping(value = "/profile")
public class ProfileController {
	
	@Autowired
	@Qualifier("userService")
	UserService userService;

	@GetMapping(value = "/getUserById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id)  throws Exception{
		return new ResponseEntity<User>(userService.getUserById(id),HttpStatus.OK);
	}
	@PostMapping("/addUser")
	public ResponseEntity<Integer> register(@RequestBody User user) throws Exception {
		return new ResponseEntity<Integer>(userService.register(user),HttpStatus.ACCEPTED);
	}
	@PostMapping("/updateUser")
	public ResponseEntity<Integer> update(@RequestBody User user) throws Exception{
		return new ResponseEntity<Integer>(userService.update(user),HttpStatus.ACCEPTED);
	}
	@PostMapping("/deleteUser/{id}")
	public ResponseEntity<Integer> delete(@PathVariable Integer id)throws Exception {
		User user = new User();user.setId(id);
		return new ResponseEntity<Integer>(userService.delete(user),HttpStatus.OK);
	}
	@GetMapping("/searchByName/{name}/{page}/{count}")
	public ResponseEntity<List<User>> searchByName(@PathVariable String name,@PathVariable int page,@PathVariable int count)throws Exception{
		return new ResponseEntity<>(userService.searchByName(name, page, count),HttpStatus.OK);
	}
	
}
