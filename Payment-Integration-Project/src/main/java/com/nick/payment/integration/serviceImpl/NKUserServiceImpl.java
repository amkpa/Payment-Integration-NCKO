package com.nick.payment.integration.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nick.payment.integration.entity.NKUser;
import com.nick.payment.integration.repo.NKUserRepo;
import com.nick.payment.integration.service.NKUserService;
import com.nick.payment.integration.user.Cnst;

@Service
public class NKUserServiceImpl implements NKUserService {
	 private boolean usernameExists = Cnst.NO;
	
    @Autowired
    private NKUserRepo userRepository;

    @Override
    public NKUser getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public NKUser getUserByUsername(String username) {
        return userRepository.findByNkUsername(username);
    }

    @Override
    public List<NKUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(NKUser user) {
        try {
        	if(userRepository.existsByNkUsername(user.getNkUsername())) {
        		usernameExists=Cnst.Yes;
        		throw new RuntimeException("Username is already taken. Please choose a different username.");
        	}
            userRepository.save(user);
        } catch (Exception e) {
            // Log the exception or print the stack trace
            
            // Handle the exception as needed
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Override
    public void updateUser(NKUser user) {
        if (userRepository.existsById(user.getNkUserId())) {
            userRepository.save(user);
        }
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

	@Override
	public boolean usernamevalidation() {
		return usernameExists;
		
	}

	@Override
	public boolean resetUsernameStatus() {
		return usernameExists=Cnst.NO;
		
	}

	@Override
	public boolean isAdmin(NKUser user) {
		return Cnst.Admin.equals(user.getNkUserRole());
	}
}
