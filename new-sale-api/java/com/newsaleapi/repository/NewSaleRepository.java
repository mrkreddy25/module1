package com.newsaleapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newsaleapi.Entity.NewSaleEntity;

@Repository
public interface NewSaleRepository extends JpaRepository<NewSaleEntity, Long> {

}
