package org.sourpy.ecomapp.Controller;

import lombok.AllArgsConstructor;
import org.sourpy.ecomapp.Dto.UserRequest;
import org.sourpy.ecomapp.Entity.User;
import org.sourpy.ecomapp.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequest userInfo){
        return new ResponseEntity<>(userService.createUser(userInfo), HttpStatus.CREATED);
    }
}
