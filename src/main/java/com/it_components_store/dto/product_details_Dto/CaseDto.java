package com.it_components_store.dto.product_details_Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CaseDto {

    private long idCase;
    private String name;
    private String code;
    private String tip;
    private String color;
    private String source;
    private String dimension;
    private Long productId;
}
