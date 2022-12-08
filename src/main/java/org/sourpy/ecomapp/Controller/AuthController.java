package org.sourpy.ecomapp.Controller;

import lombok.AllArgsConstructor;
import org.sourpy.ecomapp.Dto.LoginRequest;
import org.sourpy.ecomapp.Dto.LoginResponse;
import org.sourpy.ecomapp.Dto.RegisterRequest;
import org.sourpy.ecomapp.Dto.RegisterResponse;
import org.sourpy.ecomapp.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginInfo){
        return new ResponseEntity<>(userService.loginUser(loginInfo), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> registerUser(@RequestBody RegisterRequest registerInfo){
        return new ResponseEntity<>(userService.registerUser(registerInfo), HttpStatus.CREATED);
    }
}
