package org.sourpy.ecomapp.Security;

import lombok.AllArgsConstructor;
import org.sourpy.ecomapp.Entity.User;
import org.sourpy.ecomapp.Exception.ExceptionHandler;
import org.sourpy.ecomapp.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ExceptionHandler("User not found."));
        return new UserDetailImpl(user);
    }
}
