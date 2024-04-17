package com.backend.concesionario.interfaces.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.backend.concesionario.entity.Invoice;

public interface InvoiceService {
    ResponseEntity<Invoice> createInvoice(Invoice invoice);

    ResponseEntity<Invoice> updateInvoice(Invoice invoice);

    ResponseEntity<Void> deleteInvoice(Long invoiceId);

    ResponseEntity<Invoice> getInvoiceById(Long invoiceId);

    ResponseEntity<List<Invoice>> getAllInvoices();
}
