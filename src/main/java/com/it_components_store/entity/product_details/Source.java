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
@Table(name = "SourceDetails")
public class Source {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSource;
    private String name;
    private String code;
    private String warrant;
    private String tip;
    private String power;

    @OneToOne
    @JoinColumn(name = "id_product")
    private Product productId;

}
