package com.it_components_store.repository;

import com.it_components_store.entity.SoldProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsSoldRepository extends JpaRepository<SoldProducts, Long> {
}