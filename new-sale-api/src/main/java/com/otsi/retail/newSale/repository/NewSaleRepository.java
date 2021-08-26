package com.otsi.retail.newSale.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.otsi.retail.newSale.Entity.NewSaleEntity;

@Repository
public interface NewSaleRepository extends JpaRepository<NewSaleEntity, Long> {

	List<NewSaleEntity> findByCreatedDateBetweenAndBillStatus(LocalDate dateFrom, LocalDate dateTo, String billStatus);

	List<NewSaleEntity> findByNewsaleId(Long newsaleId);

	List<NewSaleEntity> findByBillNumber(String billNumber);

	List<NewSaleEntity> findByInvoiceNumber(Long invoiceNumber);

	List<NewSaleEntity> findByCreatedDateBetween(LocalDate dateFrom, LocalDate dateTo);

}
