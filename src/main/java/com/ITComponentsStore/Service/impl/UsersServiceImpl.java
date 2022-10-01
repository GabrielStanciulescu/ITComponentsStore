package com.ITComponentsStore.Service.impl;

import com.ITComponentsStore.Entity.Users;
import com.ITComponentsStore.Exception.DataNotFoundException;
import com.ITComponentsStore.Exception.InvalidDataException;
import com.ITComponentsStore.Repository.UsersRepository;
import com.ITComponentsStore.Service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;

    @Override
    public void addUsers(Users users) {
        if(users==null){
            throw new DataNotFoundException("Error Category not found!");
        }
        else {
            usersRepository.save(users);
        }

    }

    @Override
    public Optional<Users> getUsersById(Long id) {
        if(id<0){
            throw new InvalidDataException("Error! Your id" + id+ "it's not valid");
        }
        Optional<Users> optionalUsers = usersRepository.findById(id);
        if(optionalUsers.isEmpty()){
            throw new DataNotFoundException("Error! The category does not exist! ");
        }
        else {
            return optionalUsers;
        }
    }

    @Override
    public List<Users> getListOfUsers() {
        List<Users> usersList = usersRepository.findAll();
        if(usersList.isEmpty()){
            throw new DataNotFoundException("Error! Category list it's empty");
        }
        else{
            return usersList;
        }
    }

    @Override
    public void deleteUserById(Long id) {
        if(id<0){
            throw new InvalidDataException("Error! Your id" + id+ "it's not valid");
        }
        else{
            usersRepository.deleteById(id);

        }

    }
}
