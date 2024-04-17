package com.backend.concesionario.interfaces.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.backend.concesionario.entity.Sale;

public interface SaleService {
    ResponseEntity<Sale> createSale(Sale sale);

    ResponseEntity<Sale> updateSale(Sale sale);

    ResponseEntity<Void> deleteSale(Long saleId);

    ResponseEntity<Sale> getSaleById(Long saleId);

    ResponseEntity<List<Sale>> getAllSales();
}
