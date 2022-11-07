package com.it_components_store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
    private Long id;
    private String firstName;
    private String orderCode;
    private String lastName;
    private String email;
    private String address;
    private String mobile;
    private String description;
    private Integer quantity;
    private Long idProduct;
    private Integer price;

}
