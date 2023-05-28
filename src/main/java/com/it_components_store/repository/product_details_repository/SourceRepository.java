package com.it_components_store.repository.product_details_repository;

import com.it_components_store.entity.product_details.Case;
import com.it_components_store.entity.product_details.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SourceRepository extends JpaRepository<Source, Long> {

    @Query(value = "SELECT * FROM source_details WHERE id_product =?1", nativeQuery = true)
    Optional<Source> getByProductId(Long id);

}
