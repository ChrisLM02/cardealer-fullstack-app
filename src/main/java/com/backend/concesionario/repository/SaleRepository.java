package com.backend.concesionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.concesionario.entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
