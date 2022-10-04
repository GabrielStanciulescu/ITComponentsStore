package com.ITComponentsStore.Service;

import com.ITComponentsStore.Entity.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    void addUsers(Users users);
    Optional<Users> getUsersById(Long id);
    List<Users> getListOfUsers();
    void deleteUserById(Long id);


}
