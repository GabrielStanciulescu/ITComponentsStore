package com.it_components_store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
    private UUID uuid;
    private String firstName;

    private String lastName;

    private String email;

    private String address;

    private String mobile;

    private String description;
    private Integer quantity;


    private Long idProduct;

}
