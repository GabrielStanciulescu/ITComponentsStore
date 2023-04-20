package com.it_components_store.repository.product_details_repository;

import com.it_components_store.entity.product_details.Gpu;
import com.it_components_store.entity.product_details.Headphones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface HeadphonesRepository extends JpaRepository<Headphones, Long> {
    @Query(value = "SELECT * FROM headphones_details WHERE id_product =?1", nativeQuery = true)
    Optional<Headphones> getByProductId(Long id);
}
