package com.backend.concesionario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.concesionario.entity.Role;
import com.backend.concesionario.entity.User;
import com.backend.concesionario.interfaces.service.UserService;
import com.backend.concesionario.repository.RoleRepository;
import com.backend.concesionario.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<User> createUser(User user) {
        
        if (user.getRole() == null || user.getRole().getRoleName() == null || user.getRole().getRoleName().isEmpty()) {
            Role defaultRole = roleRepository.findByRoleName("USER");
            if (defaultRole == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
            user.setRole(defaultRole);
        } else {
            Role role = roleRepository.findByRoleName(user.getRole().getRoleName());
            if (role == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
            user.setRole(role);
        }
    
        User createdUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @Override
    public ResponseEntity<User> updateUser(User user) {
        User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<User> getUserById(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

}
