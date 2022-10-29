package com.it_components_store.service.impl;

import com.it_components_store.dto.UserDto;
import com.it_components_store.entity.User;
import com.it_components_store.exception.DataNotFoundException;
import com.it_components_store.exception.InvalidDataException;
import com.it_components_store.repository.UserRepository;
import com.it_components_store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository usersRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addUsers(UserDto userDto) {
        if (userDto == null) {
            throw new DataNotFoundException("User not found!");
        } else {
            userDto.setIdRole(2L);
            User user = modelMapper.map(userDto, User.class);
            usersRepository.save(user);
        }
    }

    @Override
    public Optional<UserDto> getUsersById(Long id) {
        if (id < 0) {
            throw new InvalidDataException(String.format("User with id %s is invalid", id));
        }
        Optional<User> optionalUsers = usersRepository.findById(id);
        if (optionalUsers.isEmpty()) {
            throw new DataNotFoundException(String.format("User with id %s is not present in database", id));
        } else {
            User user = optionalUsers.get();
            UserDto userDto = modelMapper.map(user, UserDto.class);
            return Optional.of(userDto);
        }
    }

    @Override
    public List<UserDto> getListOfUsers() {
        List<User> usersList = usersRepository.findAll();
        if (usersList.isEmpty()) {
            throw new DataNotFoundException("User list it's empty"); // this should not exist
        } else {
            List<UserDto> userDtoList;
            userDtoList = modelMapper.map(usersList, new TypeToken<List<UserDto>>() {
            }.getType());
            return userDtoList;
        }
    }

    @Override
    public void deleteUserById(Long id) {
        Optional<User> userOptional = usersRepository.findById(id);
        if (id < 0) {
            throw new InvalidDataException(String.format("User id %s it's not valid, pleas try again with id >=0", id));
        }
        if (userOptional.isEmpty()) {
            throw new DataNotFoundException(String.format("User with id %s is not present in database", id));
        }
        usersRepository.deleteById(id);
    }
}

