package com.it_components_store.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )

            }
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID uuid; //23 40  //100
    private String firstName;

    private String lastName;

    private String email;

    private String address;

    private String mobile;

    private String description;
    private Integer quantity;

    @ManyToOne()
    @JoinColumn(name = "idProduct")
    private Product product;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(uuid, order.uuid);
    }
    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
