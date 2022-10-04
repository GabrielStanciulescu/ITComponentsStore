package com.ITComponentsStore.Repository;

import com.ITComponentsStore.Entity.ProductsSold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsSoldRepository extends JpaRepository<ProductsSold, Long> {
}