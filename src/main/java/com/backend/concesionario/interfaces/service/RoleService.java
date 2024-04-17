package com.backend.concesionario.interfaces.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.backend.concesionario.entity.Role;

public interface RoleService {
    ResponseEntity<Role> createRole(Role role);

    ResponseEntity<Role> updateRole(Role role);

    ResponseEntity<Void> deleteRole(String roleName);

    ResponseEntity<Role> getRoleByName(String roleName);

    ResponseEntity<List<Role>> getAllRoles();
}
