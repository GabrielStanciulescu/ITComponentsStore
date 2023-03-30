package com.it_components_store.repository.product_details_repository;

import com.it_components_store.entity.product_details.Hdd;
import com.it_components_store.entity.product_details.Ram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface HddRepository extends JpaRepository<Hdd, Long> {
    @Query(value = "SELECT * FROM hdd_details WHERE id_product =?1", nativeQuery = true)
    Optional<Hdd> getByProductId(Long id);
}
