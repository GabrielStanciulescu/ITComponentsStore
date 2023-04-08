package com.it_components_store.repository.product_details_repository;

import com.it_components_store.entity.product_details.Hdd;
import com.it_components_store.entity.product_details.Motherboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MotherboardRepository extends JpaRepository<Motherboard, Long> {
    @Query(value = "SELECT * FROM motherboard_details WHERE id_product =?1", nativeQuery = true)
    Optional<Motherboard> getByProductId(Long id);
}
