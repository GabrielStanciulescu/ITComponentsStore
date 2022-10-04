package com.ITComponentsStore.RestControllers;

import com.ITComponentsStore.Entity.UserRol;
import com.ITComponentsStore.Entity.Users;
import com.ITComponentsStore.Service.impl.UserRolServiceImpl;
import com.ITComponentsStore.Service.impl.UsersServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsersController {
    private final UserRolServiceImpl userRolService;
    private final UsersServiceImpl usersService;

    @PostMapping("/{userRol}")
    public void addUsers(@RequestBody Users users, @PathVariable Long userRol){
        Optional<UserRol> userRol1  =  userRolService.getUserRolById(userRol);
        if(userRol1.isPresent()){
            users.setUserRol(userRol1.get());
            usersService.addUsers(users);
        }

    }

    @GetMapping("/{id}")
    Optional<Users> getUsersById(@PathVariable Long id){
      return   usersService.getUsersById(id);
    }

    @GetMapping("/all")
    List<Users> getAllUsers(){
        return usersService.getListOfUsers();
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id){
        usersService.deleteUserById(id);
    }
}
