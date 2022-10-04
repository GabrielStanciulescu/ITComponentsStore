package com.ITComponentsStore.Service;

import com.ITComponentsStore.Entity.UserRol;

import java.util.List;
import java.util.Optional;

public interface UserRolService {
    void addUserRol(UserRol userRol);
    Optional<UserRol> getUserRolById(Long id);
    List<UserRol> getAllUserRol();
    void deleteUserRolById(Long id);

}
