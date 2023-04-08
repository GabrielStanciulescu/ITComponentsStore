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
@Table(name = "MotherboardDetails")
public class Motherboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToOne
    @JoinColumn(name = "id_product")
    private Product productId;
























}
