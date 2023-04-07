package com.it_components_store.dto.product_details_Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CpuDto {
    private long idCpu;
    private String name;
    private String code;
    private String warrant;
    private String gaming;
    private String socket;
    private String series;
    private String kernel;
    private String numberOfKernel;
    private String numberOfThread;
    private String frequency;
    private String frequencyTurbo;
    private String nm;
    private String power;
    private String model;
    private String tip;
    private String memorySupported;
    private String frequencyMemory;
    private String PCIExpress;
    private String PCIExpressLanes;
    private Long productId;
}
