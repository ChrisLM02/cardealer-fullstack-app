package com.backend.concesionario.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.concesionario.entity.Sale;
import com.backend.concesionario.interfaces.service.SaleService;
import com.backend.concesionario.repository.SaleRepository;

@Service
@Transactional
public class SaleServiceImpl implements SaleService{
    private final SaleRepository saleRepository;

    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public ResponseEntity<Sale> createSale(Sale sale) {
        Sale createdSale = saleRepository.save(sale);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSale);
    }

    @Override
    public ResponseEntity<Sale> updateSale(Sale sale) {
        Sale updatedSale = saleRepository.save(sale);
        return ResponseEntity.ok(updatedSale);
    }

    @Override
    public ResponseEntity<Void> deleteSale(Long saleId) {
        saleRepository.deleteById(saleId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Sale> getSaleById(Long saleId) {
        Sale sale = saleRepository.findById(saleId).orElse(null);
        if (sale != null) {
            return ResponseEntity.ok(sale);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<Sale>> getAllSales() {
        List<Sale> sales = saleRepository.findAll();
        return ResponseEntity.ok(sales);
    }
}
