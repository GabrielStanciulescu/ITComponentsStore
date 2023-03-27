package com.it_components_store.dto.product_details_Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RamDto {
    private long idRam;
    private String  name;
    private String code;
    private String warrant;
    private String forGaming;
    private String type;
    private String capacity;
    private String frequent;
    private String latency;
    private String standard;
    private String voltage;
    private String timing;
    private Long productId;
}
