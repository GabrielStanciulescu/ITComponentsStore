package com.it_components_store.service;

import com.it_components_store.entity.User;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    void addUsers(User users);
    Optional<User> getUsersById(Long id);
    List<User> getListOfUsers();
    void deleteUserById(Long id);


}
