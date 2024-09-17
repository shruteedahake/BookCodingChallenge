package com.hexaware.book.Service;

import com.hexaware.book.dto.SignupRequest;
import com.hexaware.book.dto.UserDto;
import com.hexaware.book.entity.User;


public interface AuthService {
	
	UserDto createUser(SignupRequest signupRequest);
	
	boolean hasCustomerWithEmail(String Email);

}