package com.it_components_store.dto.product_details_Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GpuDto {
    private long idGpu;
    private String name;
    private String code;
    private String warrant;
    private String interfaces;
    private String resolution;
    private String model;
    private String cooling;
    private String gaming;
    private String chipset;
    private String series;
    private String nm;
    private String GpuGraphics;
    private String GpuBoost;
    private String tip;
    private String memory;
    private String frequency;
    private String directX;
    private String openGL;
    private String vulkan;
    private Long productId;
}
