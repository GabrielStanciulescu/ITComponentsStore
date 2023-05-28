package com.it_components_store.dto.product_details_Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MotherboardDto {

    private long idMotherboard;
    private String name;
    private String code;
    private String warrant;
    private String format;
    private String socket;
    private String chipsetManufacturer;
    private String modelChipset;
    private String cpuSupported;
    private String interfaces;
    private String gpu;
    private String numberOfSata;
    private String tip;
    private String memory;
    private String numberOfSlots;
    private String frequency;
    private Long productId;
}
