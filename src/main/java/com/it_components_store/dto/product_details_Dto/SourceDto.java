package com.it_components_store.dto.product_details_Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SourceDto {

    private long idSource;
    private String name;
    private String code;
    private String warrant;
    private String tip;
    private String power;
    private Long productId;
}
