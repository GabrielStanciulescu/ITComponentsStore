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
@Table(name = "GpuDetails")
public class Gpu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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








    @OneToOne
    @JoinColumn(name = "id_product")
    private Product productId;


}
