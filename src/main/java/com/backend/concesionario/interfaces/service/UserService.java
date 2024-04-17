package com.backend.concesionario.interfaces.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.backend.concesionario.entity.User;

public interface UserService {
    ResponseEntity<User> createUser(User user);

    ResponseEntity<User> updateUser(User user);

    ResponseEntity<Void> deleteUser(Long userId);

    ResponseEntity<User> getUserById(Long userId);

    ResponseEntity<List<User>> getAllUsers();
}
