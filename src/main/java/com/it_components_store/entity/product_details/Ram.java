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
@Table(name = "RamDetails")
public class Ram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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










    @OneToOne
    @JoinColumn(name = "id_product")
    private Product productId;
}
