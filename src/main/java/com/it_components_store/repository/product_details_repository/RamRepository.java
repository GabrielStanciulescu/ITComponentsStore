package com.it_components_store.repository.product_details_repository;

import com.it_components_store.entity.product_details.Mouse;
import com.it_components_store.entity.product_details.Ram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RamRepository extends JpaRepository<Ram, Long> {
@Query(value = "SELECT * FROM ram_details WHERE id_product =?1", nativeQuery = true)
    Optional<Ram> getByProductId(Long id);
}
