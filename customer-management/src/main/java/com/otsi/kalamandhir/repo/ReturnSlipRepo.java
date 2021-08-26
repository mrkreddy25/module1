package com.otsi.kalamandhir.repo;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.otsi.kalamandhir.model.listOfReturnSlipsModel;

/**
 * @author lakshmi
 *
 */
@Repository
public interface ReturnSlipRepo extends JpaRepository<listOfReturnSlipsModel, Long> {

	List<listOfReturnSlipsModel> findByCreatedInfoBetweenAndRtNumber(LocalDate dateFrom, LocalDate dateTo,
			String rtNumber);

	List<listOfReturnSlipsModel> findByCreatedInfoBetweenAndRtReviewStatus(LocalDate dateFrom, LocalDate dateTo,
			String rtReviewStatus);

	List<listOfReturnSlipsModel> findByCreatedInfoBetweenAndRtStatus(LocalDate dateFrom, LocalDate dateTo,
			String rtStatus);

	List<listOfReturnSlipsModel> findByCreatedInfoBetweenAndBarcode(LocalDate dateFrom, LocalDate dateTo,
			String barcode);

	List<listOfReturnSlipsModel> findByCreatedInfoBetween(LocalDate dateFrom, LocalDate dateTo);

	List<listOfReturnSlipsModel> findByRtNumber(String rtNumber);

	List<listOfReturnSlipsModel> findByRtStatus(String rtStatus);

	List<listOfReturnSlipsModel> findByCreditNote(String creditNote);

	// List<listOfReturnSlipsModel> findByBarcode(List<Barcode> list);

	List<listOfReturnSlipsModel> findByRtReviewStatus(String rtReviewStatus);

	// List<listOfReturnSlipsModel> findById(int id);

	// List<listOfReturnSlipsModel> findByBarcodeIn(List<Barcode> barcode);

	List<listOfReturnSlipsModel> findByBarcode(String barcode);

	// List<listOfReturnSlipsModel> findByCreatedInfoBetweenAndId(LocalDate
	// dateFrom, LocalDate dateTo, int id);

	List<listOfReturnSlipsModel> findByRsId(int rsId);

	List<listOfReturnSlipsModel> findByCreatedInfoBetweenAndCreditNote(LocalDate dateFrom, LocalDate dateTo,
			String creditNote);

}
