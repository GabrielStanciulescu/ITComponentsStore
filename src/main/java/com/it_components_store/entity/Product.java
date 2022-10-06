package com.it_components_store.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    private String name;
    private Integer price;
    private Integer quantity;
    private String description;
    private String productCode;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category")
    @ToString.Exclude
    private Category category;
    

    public Product(Long idProduct, String name, Integer price, Integer quantity, String description, String productCode, Category category) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.productCode = productCode;
        this.category = category;
    }

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    List<ProductsSold> productsSoldList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return idProduct != null && Objects.equals(idProduct, product.idProduct);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
