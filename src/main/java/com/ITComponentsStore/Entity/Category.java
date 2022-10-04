package com.ITComponentsStore.Entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Category(){

    }
    public Category(Long id,String name){
        this.id = id;
        this.name = name;

    }


    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    List<Product> productList;

}
