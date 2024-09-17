package com.hexaware.book.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.book.Dao.UserRepository;
import com.hexaware.book.dto.SignupRequest;
import com.hexaware.book.dto.UserDto;
import com.hexaware.book.entity.User;
import com.hexaware.book.enums.UserRole;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(SignupRequest signupRequest) {
        User user = new User();
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));

        if (signupRequest.getUserRole() == null) {
            user.setUserRole(UserRole.USER); 
        } else {
            user.setUserRole(signupRequest.getUserRole());
        }

        User createdUser = userRepository.save(user);
        UserDto userDto = new UserDto();
        userDto.setId(createdUser.getId());
        userDto.setName(createdUser.getName());
        userDto.setEmail(createdUser.getEmail());
        userDto.setUserRole(createdUser.getUserRole().name());

        return userDto;
    }

    @Override
    public boolean hasCustomerWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }
}
