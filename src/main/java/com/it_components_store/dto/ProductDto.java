package com.it_components_store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    private Long idProduct;
    @Size(max = 30, message = "The maximum length for product name")
    private String name;

    @NotNull
    private Integer price;

    @NotNull
    private Integer stock;
    @NotNull
    @Size(max = 100)

    private String description;
    @NotNull
    @Size(max = 20)
    private String code;

    @NotNull
    private Integer quantity;

    @NotNull
    private Long categoryId;

    @NotNull
    private String imageUrl;

}
