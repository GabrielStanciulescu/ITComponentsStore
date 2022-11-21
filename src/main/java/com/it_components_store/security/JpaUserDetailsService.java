package com.it_components_store.security;

import com.it_components_store.entity.User;
import com.it_components_store.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {
    private final UserServiceImpl userServiceImpl;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userServiceImpl.getUserByEmail(username);
        User user = optionalUser.orElseThrow(() -> new UsernameNotFoundException("User was not found in the database"));
        return new SecurityUsers(user);
    }
}
