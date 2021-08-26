/**
* Repo for Barcode
*/
package com.otsi.kalamandhir.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.otsi.kalamandhir.model.Barcode;

/**
 * @author vasavi
 */
@Repository
public interface BarcodeRepo extends JpaRepository<Barcode, Long> {

	Optional<Barcode> findByBarcodeId(long id);

	Optional<Barcode> findByBarcodeId(Barcode barcode);

	// Barcode findByBarcode(List<Barcode> list);

	// Barcode findByBarcodeIn(List<Barcode> barcode);

	Barcode findByBarcode(String barcode);

	Optional<Barcode> findById(int id);

}
