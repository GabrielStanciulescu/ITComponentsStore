package com.it_components_store.repository.product_details_repository;

import com.it_components_store.entity.product_details.Cpu;
import com.it_components_store.entity.product_details.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MonitorRepository extends JpaRepository<Monitor, Long> {
    @Query(value = "SELECT * FROM monitor_details WHERE id_product =?1", nativeQuery = true)
    Optional<Monitor> getByProductId(Long id);
}
