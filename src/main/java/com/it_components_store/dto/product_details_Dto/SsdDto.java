package com.it_components_store.dto.product_details_Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SsdDto {

    private long idSsd;
    private String name;
    private String code;
    private String warrant;
    private String tipSSd;
    private String formFactor;
    private String interfaces;
    private String nvme;
    private String capacity;
    private String controller;
    private String readMax;
    private String writeMax;
    private Long productId;

}
