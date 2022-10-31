package com.it_components_store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingCartDto {
    private Long idProduct;
    private String name;
    private Integer price;
    private String description;
    private Integer  quantity;
    private String imageUrl;
}
