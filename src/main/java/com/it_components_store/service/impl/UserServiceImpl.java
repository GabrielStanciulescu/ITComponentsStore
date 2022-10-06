package com.it_components_store.service.impl;

import com.it_components_store.entity.User;
import com.it_components_store.exception.DataNotFoundException;
import com.it_components_store.exception.InvalidDataException;
import com.it_components_store.repository.UserRepository;
import com.it_components_store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository usersRepository;

    @Override
    public void addUsers(User users) {
        if (users == null) {
            throw new DataNotFoundException("Error Category not found!");
        } else {
            usersRepository.save(users);
        }
    }

    @Override
    public Optional<User> getUsersById(Long id) {
        if (id < 0) {
            throw new InvalidDataException("Error! Your id " + id + " it's not valid");
        }
        Optional<User> optionalUsers = usersRepository.findById(id);
        if (optionalUsers.isEmpty()) {
            throw new DataNotFoundException("Error! The category with id " + id + " does not exist!");
        } else {
            return optionalUsers;
        }
    }

    @Override
    public List<User> getListOfUsers() {
        List<User> usersList = usersRepository.findAll();
        if (usersList.isEmpty()) {
            throw new DataNotFoundException("Error! Category list it's empty");
        } else {
            return usersList;
        }
    }

    @Override
    public void deleteUserById(Long id) {
        Optional<User> categoryOptional = usersRepository.findById(id);
        if (id < 0) {
            throw new InvalidDataException("Error! Your id " + id + " it's not valid, pleas try again with id >=0");
        }
        if (categoryOptional.isEmpty()) {
            throw new DataNotFoundException("Error User with id " + id + " it's not present in database");
        }
        usersRepository.deleteById(id);
    }
}
