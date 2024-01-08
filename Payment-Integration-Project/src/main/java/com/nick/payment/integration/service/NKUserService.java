package com.nick.payment.integration.service;

import java.util.List;

import com.nick.payment.integration.entity.NKUser;
import com.nick.payment.integration.user.Cnst;

public interface NKUserService {
	NKUser getUserById(Long userId);

	NKUser getUserByUsername(String username);

	List<NKUser> getAllUsers();

	void saveUser(NKUser user);

	void updateUser(NKUser user);

	void deleteUser(Long userId);
	
	boolean usernamevalidation();
	
	boolean resetUsernameStatus();
	
	boolean isAdmin(NKUser user);

	
}
