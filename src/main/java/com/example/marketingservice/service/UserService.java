package com.example.marketingservice.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.marketingservice.model.User;
import com.example.marketingservice.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}