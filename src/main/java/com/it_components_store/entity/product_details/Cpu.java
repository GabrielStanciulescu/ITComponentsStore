package com.it_components_store.entity.product_details;


import com.it_components_store.entity.Product;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CpuDetails")
public class Cpu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToOne
    @JoinColumn(name = "id_product")
    private Product productId;









}
