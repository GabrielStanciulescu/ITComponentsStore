package com.it_components_store.mocks;

import com.it_components_store.entity.Role;
import com.it_components_store.entity.User;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsersMock {
    public static User getOneUser() {
        Role role = Role.builder().idRole(1L).name("ROLE_ADMIN").build();
        return User.builder().lastName("test").firstName("test").address("test").role(role).build();

    }

    public static List<User> getListUsers() {
        Role role = Role.builder().idRole(1L).name("ROLE_ADMIN").build();
        return List.of(User.builder().lastName("test").firstName("test").address("test").role(role).build());
    }
}
