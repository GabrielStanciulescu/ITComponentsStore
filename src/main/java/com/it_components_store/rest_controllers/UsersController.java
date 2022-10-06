package com.it_components_store.rest_controllers;

import com.it_components_store.entity.Role;
import com.it_components_store.entity.User;
import com.it_components_store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsersController {

    private final UserService usersService;

    @PostMapping("/get")
    public void addUsers(@RequestBody User user) {
        user.setRole(Role.builder().idRole(1L).name("ADMIN").build());
        usersService.addUsers(user);
    }

    @GetMapping("/{id}")
    Optional<User> getUsersById(@PathVariable Long id) {
        return usersService.getUsersById(id);
    }

    @GetMapping("/all")
    List<User> getAllUsers() {
        return usersService.getListOfUsers();
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        usersService.deleteUserById(id);
    }
}
