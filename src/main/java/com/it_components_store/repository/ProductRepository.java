package com.it_components_store.repository;

import com.it_components_store.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getAllByCategory_IdCategory(Long id);

    List<Product> findAllByDescriptionIsContainingIgnoreCase(String keywords);

    @Query(value = "SELECT * FROM products ORDER BY ?1",nativeQuery = true)
    List<Product> findByCustomSearch(String custom);
}
/*   @Query(value = "SELECT * FROM products WHERE description LIKE %?1%",nativeQuery = true)
    List<Product> getProducts(String keywords);

 */