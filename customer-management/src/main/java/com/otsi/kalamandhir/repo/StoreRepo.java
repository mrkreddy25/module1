/**
 * Repo for Store
 */
package com.otsi.kalamandhir.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.otsi.kalamandhir.model.Store;
/**
 * @author vasavi
 */
@Repository
public interface StoreRepo extends JpaRepository<Store, Long> {

}
