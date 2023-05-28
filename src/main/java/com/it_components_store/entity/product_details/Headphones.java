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
@Table(name = "HeadphonesDetails")
public class Headphones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idHeadphones;
    private String name;
    private String warrant;
    private String technology;
    private String sound;
    private String microphone;





    @OneToOne
    @JoinColumn(name = "id_product")
    private Product productId;

}
