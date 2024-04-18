package com.backend.concesionario.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.concesionario.entity.Role;
import com.backend.concesionario.entity.User;
import com.backend.concesionario.jwt.JwtService2;
import com.backend.concesionario.repository.RoleRepository;
import com.backend.concesionario.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JwtService2 jwtService2;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user= userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService2.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();
    }

    public AuthResponse register(RegisterRequest request) {
        Role defaultRole = roleRepository.findByRoleName("USER");

        Role userRole = request.getRole();
        
        if (userRole == null || userRole.getRoleName() == null || userRole.getRoleName().isEmpty()) {
            userRole = defaultRole;
        }

        User user = User.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode( request.getPassword()))
            .firstName(request.getFirstname())
            .lastName(request.lastname)
            .identificationNumber(request.identificationNumber)
            .address(request.address)
            .role(userRole)
            .build();

        userRepository.save(user);

        return AuthResponse.builder()
            .token(jwtService2.getToken(user))
            .build();
    }
    
}
