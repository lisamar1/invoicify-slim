package com.lmig.gfc.invoicify.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lmig.gfc.invoicify.models.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository <Invoice, Long> {

}

