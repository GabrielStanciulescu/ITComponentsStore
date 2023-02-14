package com.it_components_store.mocks;

import com.it_components_store.entity.Role;
import com.it_components_store.entity.User;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsersMock {
    public static User getOneUser() {
        Role role = Role.builder().idRole(1L).build();
        return User.builder().lastName("test").firstName("test").address("gabriel.stanculescu08@gmail.com").password("$2a$12$fr391cwxTqQwqG0gQ5e0aOhfOAtoTwV/1t9NWZCP6/s17PjOO81by").resetPasswordToken("BED1fNhxlAky6m0VZZ4h6QwWccWpzd").role(role).build();

    }

    public static List<User> getListUsers() {
        Role role = Role.builder().idRole(2L).name("ROLE_ADMIN").build();
        return List.of(User.builder().lastName("test").firstName("test").address("gabriel.stanculescu08@gmail.com").role(role).resetPasswordToken("BED1fNhxlAky6m0VZZ4h6QwWccWpzd").build());
    }
}
