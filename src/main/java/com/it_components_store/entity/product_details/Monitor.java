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
@Table(name = "MonitorDetails")
public class Monitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMonitor;
    private String name;
    private String warrant;
    private String panel;
    private String diagonal;
    private String antiGlare;
    private String resolution;
    private String refreshRate;




    @OneToOne
    @JoinColumn(name = "id_product")
    private Product productId;

}
