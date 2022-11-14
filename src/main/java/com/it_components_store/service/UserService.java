package com.it_components_store.service;

import com.it_components_store.dto.UserDto;
import com.it_components_store.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void addUsers(UserDto userDto);
    Optional<UserDto> getUsersById(Long id);
    List<UserDto> getListOfUsers();
    void deleteUserById(Long id);
    Optional<User> getUserByEmail(String email);


}
