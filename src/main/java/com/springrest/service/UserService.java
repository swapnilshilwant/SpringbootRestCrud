package com.springrest.service;

import java.util.List;

import com.springrest.entity.User;

public interface UserService {
	
	public User createUser(User user);

    public User getUserById(Long userId);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long userId);
}
