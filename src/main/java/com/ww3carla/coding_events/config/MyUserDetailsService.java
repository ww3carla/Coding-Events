package com.ww3carla.coding_events.config;

import com.ww3carla.coding_events.models.User;
import com.ww3carla.coding_events.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Slf4j
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            log.error("Could not find user with that username: {}", username);
            throw new UsernameNotFoundException("Invalid credentials!");
        }

        User userDetails = user.get();

        if(!userDetails.getUsername().equals(username)) {
            log.error("Could not find user with that username: {}", username);
            throw new UsernameNotFoundException("Invalid credentials!");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        userDetails.getRoles().stream()
                .forEach(authority -> grantedAuthorities.add(new SimpleGrantedAuthority(authority.getRole())));

        return new MySecurityUser(userDetails.getUsername(), userDetails.getPassword(), true, true, true, true,
                grantedAuthorities, userDetails.getFirstName(), userDetails.getLastName(), userDetails.getEmailAddress(), userDetails.getBirthDate());

    }
}
