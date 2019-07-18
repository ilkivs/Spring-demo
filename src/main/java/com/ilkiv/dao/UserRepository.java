package com.ilkiv.dao;

import com.ilkiv.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph("User.roles")
    Optional<User> getById(Long id);

    @EntityGraph("User.roles")
    Optional<User> getByUsername(String username);
}
