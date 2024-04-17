package com.backend.concesionario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.concesionario.entity.Sale;
import com.backend.concesionario.interfaces.service.SaleService;

@RestController
@RequestMapping("/api/sales")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @PostMapping
    public ResponseEntity<Sale> createSale(@RequestBody Sale sale) {
        return saleService.createSale(sale);
    }

    @PutMapping("/{saleId}")
    public ResponseEntity<Sale> updateSale(@PathVariable Long saleId, @RequestBody Sale sale) {
        sale.setSaleId(saleId);
        return saleService.updateSale(sale);
    }

    @DeleteMapping("/{saleId}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long saleId) {
        return saleService.deleteSale(saleId);
    }

    @GetMapping("/{saleId}")
    public ResponseEntity<Sale> getSaleById(@PathVariable Long saleId) {
        return saleService.getSaleById(saleId);
    }

    @GetMapping
    public ResponseEntity<List<Sale>> getAllSales() {
        return saleService.getAllSales();
    }
}
