package org.sourpy.ecomapp.Service;

import lombok.AllArgsConstructor;
import org.sourpy.ecomapp.Dto.UserCreateDto;
import org.sourpy.ecomapp.Entity.User;
import org.sourpy.ecomapp.Exception.UserNotFoundException;
import org.sourpy.ecomapp.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(UserCreateDto userInfo) {
        return userRepository.save(User.builder()
                .name(userInfo.getName())
                .surname(userInfo.getSurname())
                .username(userInfo.getUsername())
                .password(userInfo.getPassword())
                .email(userInfo.getEmail()).build()
        );
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
