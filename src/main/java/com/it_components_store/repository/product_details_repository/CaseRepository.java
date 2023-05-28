package com.it_components_store.repository.product_details_repository;

import com.it_components_store.entity.product_details.Case;
import com.it_components_store.entity.product_details.Cpu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CaseRepository extends JpaRepository<Case, Long> {

    @Query(value = "SELECT * FROM case_details WHERE id_product =?1", nativeQuery = true)
    Optional<Case> getByProductId(Long id);

}
