package com.it_components_store.mocks;

import com.it_components_store.entity.Role;
import com.it_components_store.entity.User;

import java.util.List;

public class UsersMock {
    public static User getOneUser() {
        Role userRol = new Role(1L, "ADMIN");
//        return new User(1L,"test","test","test","test","test","test",userRol, LocalDate.of(2001, 3, 8));
        return User.builder().lastName("test").firstName("test").address("test").role(userRol).build();

    }

    public static List<User> getListUsers() {
        Role userRol = new Role(1L, "ADMIN");
        return List.of(User.builder().lastName("test").firstName("test").address("test").role(userRol).build());
    }
}
