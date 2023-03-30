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
@Table(name = "SsdDetails")
public class Ssd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    @OneToOne
    @JoinColumn(name = "id_product")
    private Product productId;

}
