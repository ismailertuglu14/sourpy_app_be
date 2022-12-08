package org.sourpy.ecomapp.Service;

import lombok.AllArgsConstructor;
import org.sourpy.ecomapp.Dto.*;
import org.sourpy.ecomapp.Entity.User;
import org.sourpy.ecomapp.Exception.ExceptionHandler;
import org.sourpy.ecomapp.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(UserRequest userInfo) {
        return userRepository.save(User.builder()
                .name(userInfo.getName())
                .surname(userInfo.getSurname())
                .username(userInfo.getUsername())
                .password(userInfo.getPassword())
                .email(userInfo.getEmail()).build()
        );
    }

    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ExceptionHandler("User not found"));
    }

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ExceptionHandler("Username not found"));
    }

    public LoginResponse loginUser(LoginRequest loginInfo) {
        User user = getUserByUsername(loginInfo.getUsername());
        if(!user.getPassword().equals(loginInfo.getPassword())){
            throw new ExceptionHandler("Password incorrect!");
        }
        return LoginResponse.builder()
                .username(loginInfo.getUsername())
                .message("Logged in successfully.")
                .build();
    }

    public RegisterResponse registerUser(RegisterRequest registerInfo) {
        if(!userRepository.findByUsername(registerInfo.getUsername()).isEmpty()){
            throw new ExceptionHandler("Username already taken!");
        }

        userRepository.save(User.builder()
                .name(registerInfo.getName())
                .surname(registerInfo.getSurname())
                .username(registerInfo.getUsername())
                .password(registerInfo.getPassword())
                .email(registerInfo.getEmail()).build()
        );

        return RegisterResponse.builder()
                .username(registerInfo.getUsername())
                .message("Successfully registered.")
                .build();
    }
}
