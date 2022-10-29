package com.it_components_store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    private Long idProduct;

    private String name;

    private Integer price;

    private Integer stock;

    private String description;

    private String code;

    private Integer quantity;

    private String imageUrl;

    private Long categoryId;

    private Long orderId;
}
