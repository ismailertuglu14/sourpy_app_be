package org.sourpy.ecomapp.Service;

import lombok.AllArgsConstructor;
import org.sourpy.ecomapp.Dto.*;
import org.sourpy.ecomapp.Entity.User;
import org.sourpy.ecomapp.Exception.ExceptionHandler;
import org.sourpy.ecomapp.Repository.UserRepository;
import org.sourpy.ecomapp.Security.TokenUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
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
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginInfo.getUsername(), loginInfo.getPassword()));
        User user = getUserByUsername(((UserDetails) auth.getPrincipal()).getUsername());
        return LoginResponse
                .builder()
                .username(loginInfo.getUsername())
                .message("Logged in successfully.")
                .token(TokenUtils.createToken(user.getId(),user.getUsername()))
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
                .password(passwordEncoder.encode(registerInfo.getPassword()))
                .email(registerInfo.getEmail()).build()
        );

        return RegisterResponse.builder()
                .username(registerInfo.getUsername())
                .message("Successfully registered.")
                .build();
    }

    public LoginResponse isLoggedIn(String token) {
        token = token.replace("Bearer ","");
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return LoginResponse
                .builder()
                .username(name)
                .message("User still active.")
                .token(token)
                .build();
    }
}
