package com.backend.concesionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.concesionario.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}
