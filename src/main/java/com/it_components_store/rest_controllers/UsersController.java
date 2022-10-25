package com.it_components_store.rest_controllers;

import com.it_components_store.dto.UserDto;
import com.it_components_store.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsersController {

    private final UserServiceImpl usersService;

    @PostMapping("/add")
    public void addUsers(@RequestBody UserDto userDto) {

        usersService.addUsers(userDto);
    }

    @GetMapping("/{id}")
    Optional<UserDto> getUsersById(@PathVariable Long id) {
        return usersService.getUsersById(id);
    }

    @GetMapping("/all")
    List<UserDto> getAllUsers() {
        return usersService.getListOfUsers();
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        usersService.deleteUserById(id);
    }
}
