package com.it_components_store.repository.product_details_repository;

import com.it_components_store.entity.product_details.Mouse;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MouseRepository extends JpaRepository<Mouse, Long> {
    @Query(value = "SELECT * FROM mouse_details  WHERE id_product =?1",nativeQuery = true)
    Optional<Mouse> getByProductId(Long id);
}
