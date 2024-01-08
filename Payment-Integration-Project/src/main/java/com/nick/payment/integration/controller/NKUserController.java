package com.nick.payment.integration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nick.payment.integration.entity.NKUser;
import com.nick.payment.integration.exception.DuplicateUsernameException;
import com.nick.payment.integration.service.NKUserService;

@RestController
@RequestMapping("/users")
public class NKUserController {

	@Autowired
	private NKUserService userService;

	@GetMapping("/all")
	public ResponseEntity<Object> getAllUsers() {
		return ResponseEntity.ok().body(userService.getAllUsers());
	}

	@GetMapping("/create")
	public ResponseEntity<Object> showCreateUserForm() {
		return ResponseEntity.ok().body("Please use a POST request to create a user.");
	}

	@PostMapping("/create")
	public ResponseEntity<Object> createUser(@RequestBody List<NKUser> user) {
		try {
			for (NKUser users : user) {
				userService.saveUser(users);
			}
			if (userService.usernamevalidation()) {
				userService.resetUsernameStatus();
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username is Already There");
			}
			return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully.");
		} catch (DuplicateUsernameException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
		}
	}

	@GetMapping("/update/{userId}")
	public ResponseEntity<Object> showUpdateUserForm(@PathVariable Long userId) {
		NKUser user = userService.getUserById(userId);
		if (user != null) {
			return ResponseEntity.ok().body(user);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
		}
	}

	@PostMapping("/update/{userId}")
	public String updateUser(@PathVariable Long userId, @ModelAttribute NKUser user, Model model) {
	    NKUser existingUser = userService.getUserById(userId);
	    if (existingUser != null) {
	        if (userService.isAdmin(existingUser)) {
	            user.setNkAccountLocked(existingUser.isNkAccountLocked());
	            user.setNkAccountActivated(existingUser.isNkAccountActivated());
	        }
	        user.setNkUserId(userId);
	        userService.updateUser(user);
	        model.addAttribute("message", "User updated successfully.");
	    }
	    return "redirect:/users/all";
	}

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<Object> deleteUser(@PathVariable Long userId) {
		NKUser existingUser = userService.getUserById(userId);
		if (existingUser != null) {
			userService.deleteUser(userId);
			return ResponseEntity.ok().body("User deleted successfully.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
		}
	}
}
