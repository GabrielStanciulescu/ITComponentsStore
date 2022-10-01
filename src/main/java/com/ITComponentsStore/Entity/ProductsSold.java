package com.ITComponentsStore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class ProductsSold {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_productSold;
    private Integer quantity;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product")
    private Product product;
}
