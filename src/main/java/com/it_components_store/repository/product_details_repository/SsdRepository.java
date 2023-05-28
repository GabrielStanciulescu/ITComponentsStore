package com.it_components_store.repository.product_details_repository;

import com.it_components_store.entity.product_details.Hdd;
import com.it_components_store.entity.product_details.Ssd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SsdRepository extends JpaRepository<Ssd, Long> {
    @Query(value = "SELECT * FROM ssd_details WHERE id_product =?1", nativeQuery = true)
    Optional<Ssd> getByProductId(Long id);
}
