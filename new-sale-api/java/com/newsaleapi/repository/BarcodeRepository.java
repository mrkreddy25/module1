package com.newsaleapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newsaleapi.Entity.BarcodeEntity;

public interface BarcodeRepository extends JpaRepository<BarcodeEntity, Long> {

	BarcodeEntity findByBarcode(String barCode);

}
