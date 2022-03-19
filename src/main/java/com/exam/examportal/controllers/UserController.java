
package com.exam.examportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examportal.entities.User;
import com.exam.examportal.repositories.UserRepository;
import com.exam.examportal.services.impl.UserDetailsImpl;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	/*
	 * @Autowired private UserService userService;
	 * 
	 * @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
	 * 
	 * @PostMapping("/register") public User createUser(@RequestBody User user)
	 * throws Exception {
	 * 
	 * Set<Role> roles = new HashSet<>();
	 * user.setPassword(bCryptPasswordEncoder.encode(user.getPassword())); Role role
	 * = new Role(); // role.set(45L); //role.setRoleName("NORMAL");
	 * 
	 * Role userRole = new Role(); // userRole.setUser(user); //
	 * userRole.setRole(role);
	 * 
	 * roles.add(userRole);
	 * 
	 * return userService.createUser(user, roles);
	 * 
	 * }
	 * 
	 * @GetMapping("/{username}") public User getUser(@PathVariable("username")
	 * String username) { User user = userService.findByUsername(username); return
	 * user;
	 * 
	 * }
	 * 
	 * @DeleteMapping("/{userId}") public void getUser(@PathVariable("userId") long
	 * id) { userService.deleteUser(id);
	 * 
	 * }
	 */

	@GetMapping("/current-user")
	public ResponseEntity<?> getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		/*
		 * List<String> roles = userDetails.getAuthorities().stream().map(item ->
		 * item.getAuthority()) .collect(Collectors.toList());
		 */
		User findByUsername = userRepository.findByUsername(userDetails.getUsername()).get();
		
		return ResponseEntity.ok(findByUsername);

	}
}
