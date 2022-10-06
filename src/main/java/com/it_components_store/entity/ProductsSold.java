package com.it_components_store.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class ProductsSold {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProductSold;
    private Integer quantity;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product")
    @ToString.Exclude
    private Product product;



    public ProductsSold(Long idProductSold, Integer quantity, Product product) {
        this.idProductSold = idProductSold;
        this.quantity = quantity;
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductsSold that = (ProductsSold) o;
        return idProductSold != null && Objects.equals(idProductSold, that.idProductSold);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
