package com.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.entity.User;
import com.springrest.service.UserService;

	@RestController
	@RequestMapping("/api")
	public class UserController {
		@Autowired
	    private UserService userService;

	    @PostMapping("/add")
	    public ResponseEntity<User> createUser(@RequestBody User user){
	        User savedUser = userService.createUser(user);
	        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	    }

	    @GetMapping("/users/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable("id") Long id)
	    {
	        User user = userService.getUserById(id);
	        return new ResponseEntity<>(user, HttpStatus.OK);
	    }

	    @GetMapping("/users")
	    public ResponseEntity<List<User>> getAllUsers()
	    {
	        List<User> users = userService.getAllUsers();
	        return new ResponseEntity<>(users, HttpStatus.OK);
	    }

	    @PutMapping("/users/{id}")
	    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,@RequestBody User user)
	    {
	        user.setId(userId);
	        User updatedUser = userService.updateUser(user);
	        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	    }

	    @DeleteMapping("/users/{id}")
	    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId)
	    {
	        userService.deleteUser(userId);
	        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
	    }

}
