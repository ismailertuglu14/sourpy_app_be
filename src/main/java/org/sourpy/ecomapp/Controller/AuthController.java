package org.sourpy.ecomapp.Controller;

import lombok.AllArgsConstructor;
import org.sourpy.ecomapp.Dto.LoginRequest;
import org.sourpy.ecomapp.Dto.LoginResponse;
import org.sourpy.ecomapp.Dto.RegisterRequest;
import org.sourpy.ecomapp.Dto.RegisterResponse;
import org.sourpy.ecomapp.Entity.User;
import org.sourpy.ecomapp.Security.TokenUtils;
import org.sourpy.ecomapp.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginRequest loginInfo){
        return new ResponseEntity<>(userService.loginUser(loginInfo), HttpStatus.OK);
    }

    @PostMapping("/is_logged_in")
    public ResponseEntity<LoginResponse> stillLogin(@RequestHeader("Authorization") String token){
        return new ResponseEntity<>(userService.isLoggedIn(token), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> registerUser(@RequestBody RegisterRequest registerInfo){
        return new ResponseEntity<>(userService.registerUser(registerInfo), HttpStatus.CREATED);
    }
}
