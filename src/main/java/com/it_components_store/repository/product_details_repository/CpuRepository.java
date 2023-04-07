package com.it_components_store.repository.product_details_repository;

import com.it_components_store.entity.product_details.Cpu;
import com.it_components_store.entity.product_details.Hdd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CpuRepository extends JpaRepository<Cpu, Long> {
    @Query(value = "SELECT * FROM cpu_details WHERE id_product =?1", nativeQuery = true)
    Optional<Cpu> getByProductId(Long id);

}
