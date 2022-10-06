package com.it_components_store.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sold_products")
public class SoldProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSoldProducts;

    private Integer quantity;

    @JsonIgnore
    @OneToMany(mappedBy = "soldProducts")
    @ToString.Exclude
    private List<Product> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SoldProducts that = (SoldProducts) o;
        return idSoldProducts != null && Objects.equals(idSoldProducts, that.idSoldProducts);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
