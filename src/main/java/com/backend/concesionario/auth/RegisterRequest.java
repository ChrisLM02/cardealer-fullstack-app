package com.backend.concesionario.auth;

import com.backend.concesionario.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    String username;
    String password;
    String identificationNumber;
    String firstname;
    String lastname;
    Role role;
    String address;
}
