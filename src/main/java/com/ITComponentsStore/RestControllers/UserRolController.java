package com.ITComponentsStore.RestControllers;

import com.ITComponentsStore.Entity.UserRol;
import com.ITComponentsStore.Service.impl.UserRolServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/userRol", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRolController {
    private final UserRolServiceImpl userRolService;

    @PostMapping()
    public  void addUserRol(@RequestBody UserRol userRol){
        userRolService.addUserRol(userRol);
    }

    @GetMapping("/{id}")
    Optional<UserRol> getUserRoloById(@PathVariable Long id){
        return userRolService.getUserRolById(id);
    }

    @GetMapping("/all")
    List<UserRol> getAllUserRol(){
        return userRolService.getAllUserRol();
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id){
        userRolService.deleteUserRolById(id);
    }
}

