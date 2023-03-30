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
@Table(name = "HddDetails")
public class Hdd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idHdd;
    private String name;
    private String code;
    private String warrant;
    private String interfaces;
    private String capacity;
    private String buffer;
    private String speed;



    @OneToOne
    @JoinColumn(name = "id_product")
    private Product productId;

}
