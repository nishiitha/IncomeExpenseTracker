package com.mini.incomeExpenseTracker.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.mini.incomeExpenseTracker.entities.User;
import com.mini.incomeExpenseTracker.web.dto.UserRegistrationDto;



public interface UserService extends UserDetailsService{

	User save(UserRegistrationDto registrationDto);
	
}