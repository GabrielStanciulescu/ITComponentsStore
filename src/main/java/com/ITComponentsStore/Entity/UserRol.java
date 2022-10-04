package com.ITComponentsStore.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class UserRol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rol;
    @OneToMany(mappedBy = "userRol",fetch = FetchType.EAGER)
    List<Users> usersList;

}
