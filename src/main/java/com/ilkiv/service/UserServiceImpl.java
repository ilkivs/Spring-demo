package com.ilkiv.service;

import com.ilkiv.dao.UserRepository;
import com.ilkiv.model.Role;
import com.ilkiv.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public User add(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRoles(singletonList(Role.ofUser()));
        return userRepository.save(user);
    }

    @Override
    public Optional<List<User>> getAll() {
        return Optional.ofNullable(userRepository.findAll());
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getByUsername(username)
                .map(user -> org.springframework.security.core.userdetails.User
                        .builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .authorities(toAuthorities(user.getRoles()))
                        .build())
                .orElseGet(() -> org.springframework.security.core.userdetails.User.builder()
                        .build());
    }

    private List<GrantedAuthority> toAuthorities(List<Role> roles) {
        return roles.stream()
                .map(r -> new SimpleGrantedAuthority(r.getName()))
                .collect(toList());
    }
}
