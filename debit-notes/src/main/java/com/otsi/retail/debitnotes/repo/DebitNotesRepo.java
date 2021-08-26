package com.otsi.retail.debitnotes.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.otsi.retail.debitnotes.model.DebitNotes;

@Repository
public interface DebitNotesRepo extends JpaRepository<DebitNotes, Integer> {

	Optional<DebitNotes> findByDrNo(String drNo);

}
