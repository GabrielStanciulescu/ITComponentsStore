package com.it_components_store.repository;

import com.it_components_store.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    @Query(value = "SELECT * FROM shopping_cart WHERE  id_user =?1",nativeQuery = true)
    List<ShoppingCart> getShoppingCartByIdUser(Long idUser);


    @Modifying
    @Query(value = "DELETE  FROM shopping_cart t WHERE  t.id_user =?1",nativeQuery = true)
    void deleteShoppingCartByIdUser(Long idUser);

}
