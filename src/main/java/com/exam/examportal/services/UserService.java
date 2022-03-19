package com.exam.examportal.services;

import java.util.Set;

import com.exam.examportal.entities.Role;
import com.exam.examportal.entities.User;

public interface UserService {
	
	public User createUser(User user, Set<Role> userRoles) throws Exception;

	public User findByUsername(String username);

	public void deleteUser(long id);

}
