package com.ITComponentsStore.Service.impl;

import com.ITComponentsStore.Entity.ProductsSold;
import com.ITComponentsStore.Entity.UserRol;
import com.ITComponentsStore.Exception.DataNotFoundException;
import com.ITComponentsStore.Exception.InvalidDataException;
import com.ITComponentsStore.Repository.UserRolRepository;
import com.ITComponentsStore.Service.UserRolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRolServiceImpl implements UserRolService {

    private final UserRolRepository userRolRepository;
    @Override
    public void addUserRol(UserRol userRol) {
        if(userRol==null){
            throw new DataNotFoundException("Error userRol not found!");
        }
        else {
            userRolRepository.save(userRol);
        }
    }

    @Override
    public Optional<UserRol> getUserRolById(Long id) {
        if(id<0){
            throw new InvalidDataException("Error! Your id" + id+ "it's not valid");
        }
        Optional<UserRol> userRolOptional = userRolRepository.findById(id);
        if(userRolOptional.isEmpty()){
            throw new DataNotFoundException("Error! The userRol with id " + id + " does not exist! ");
        }
        else {
            return userRolOptional;
        }
    }

    @Override
    public List<UserRol> getAllUserRol() {
        List<UserRol> userRolList = userRolRepository.findAll();
        if(userRolList.isEmpty()){
            throw new DataNotFoundException("Error! userRol list it's empty");
        }
        else{
            return userRolList;
        }
    }

    @Override
    public void deleteUserRolById(Long id) {
        Optional<UserRol> categoryOptional = userRolRepository.findById(id);
        if(id<0){
            throw new InvalidDataException("Error! Your id" + id+ " it's not valid, pleas try again with id >=0");
        }
        if(categoryOptional.isEmpty()){
            throw new DataNotFoundException("Error  Product with id " + id + " it's not present in database");
        }

        userRolRepository.deleteById(id);

    }
}
