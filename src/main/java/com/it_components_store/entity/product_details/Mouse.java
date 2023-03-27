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
@Table(name = "MouseDetails")
public class Mouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMouse;
    private String name;
    private String interfaceMouse;
    private String sensor;
    private String color;

    @OneToOne
    @JoinColumn(name = "id_product")
    private Product productId;


}
