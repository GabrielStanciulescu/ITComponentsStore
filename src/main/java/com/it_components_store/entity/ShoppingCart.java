package com.it_components_store.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idShoppingCart;
    private String name;

    private Integer price;

    private Integer quantity;

    private String description;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "idProduct")
    private Product product;
}
