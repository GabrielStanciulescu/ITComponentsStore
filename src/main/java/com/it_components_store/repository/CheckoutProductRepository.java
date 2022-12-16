package com.it_components_store.repository;

import com.it_components_store.entity.CheckoutProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckoutProductRepository extends JpaRepository<CheckoutProduct, Long> {
    @Query(value = "SELECT * FROM checkout_product WHERE  id_user =?1",nativeQuery = true)
    List<CheckoutProduct> getCheckoutProductByIdUser(Long idUser);
}