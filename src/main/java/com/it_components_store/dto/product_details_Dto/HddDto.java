package com.it_components_store.dto.product_details_Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HddDto {

    private long idHdd;
    private String name;
    private String code;
    private String warrant;
    private String interfaces;
    private String capacity;
    private String buffer;
    private String speed;
    private Long productId;
}
