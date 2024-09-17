package com.hexaware.book.Service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	UserDetailsService userDetailsService();


}
