package com.it_components_store.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "checkout_product")
public class CheckoutProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer price;
    private String orderCode;
    private LocalDate localDate;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

}
