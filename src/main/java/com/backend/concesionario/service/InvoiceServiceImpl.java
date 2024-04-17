package com.backend.concesionario.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.concesionario.entity.Invoice;
import com.backend.concesionario.interfaces.service.InvoiceService;
import com.backend.concesionario.repository.InvoiceRepository;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService{

    public final InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository){
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public ResponseEntity<Invoice> createInvoice(Invoice invoice) {
        Invoice createdInvoice = invoiceRepository.save(invoice);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInvoice);
    }

    @Override
    public ResponseEntity<Invoice> updateInvoice(Invoice invoice) {
        Invoice updatedInvoice = invoiceRepository.save(invoice);
        return ResponseEntity.ok(updatedInvoice);
    }

    @Override
    public ResponseEntity<Void> deleteInvoice(Long invoiceId) {
        invoiceRepository.deleteById(invoiceId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Invoice> getInvoiceById(Long invoiceId) {
        return invoiceRepository.findById(invoiceId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();
        return ResponseEntity.ok(invoices);
    }

}
