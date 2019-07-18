package com.ilkiv.service;

import com.ilkiv.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    User add(User user);

    Optional<List<User>> getAll();

    Optional<User> getById(Long id);
}
