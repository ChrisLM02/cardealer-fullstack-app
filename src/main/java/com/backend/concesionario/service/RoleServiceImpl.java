package com.backend.concesionario.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.concesionario.entity.Role;
import com.backend.concesionario.interfaces.service.RoleService;
import com.backend.concesionario.repository.RoleRepository;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public ResponseEntity<Role> createRole(Role role) {
        Role createdRole = roleRepository.save(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRole);
    }

    @Override
    public ResponseEntity<Role> updateRole(Role role) {
        Role updatedRole = roleRepository.save(role);
        return ResponseEntity.ok(updatedRole);
    }

    @Override
    public ResponseEntity<Void> deleteRole(String roleName) {
        roleRepository.deleteById(roleName);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Role> getRoleByName(String roleName) {
        Role role = roleRepository.findById(roleName).orElse(null);
        if (role != null) {
            return ResponseEntity.ok(role);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return ResponseEntity.ok(roles);
    }
}
