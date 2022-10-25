package com.it_components_store.rest_controllers;

import com.it_components_store.dto.UserDto;
import com.it_components_store.service.impl.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.it_components_store.mocks.UserMockDto.getListUsersDto;
import static com.it_components_store.mocks.UserMockDto.getOneUserDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsersControllerTest {
    @InjectMocks
    UsersController usersController;

    @Mock
    UserServiceImpl userService;

    @Captor
    ArgumentCaptor<UserDto> userArgumentCaptor;

    @Captor
    ArgumentCaptor<Long> longArgumentCaptor;

    @Test
    void addUsers() {
        UserDto user = getOneUserDto();
        usersController.addUsers(user);
        verify(userService,times(1)).addUsers(userArgumentCaptor.capture());
      assertEquals(user,userArgumentCaptor.getValue());

    }

    @Test
    @DisplayName("Test get user by name")
    void testGetUserByName() {
        when(userService.getUsersById(1L)).thenReturn(Optional.of(getOneUserDto()));
        Optional<UserDto> userOptional = usersController.getUsersById(1L);
        if(userOptional.isPresent()){
            UserDto user = userOptional.get();
            assertEquals(getOneUserDto().toString(), user.toString());
        }
    }

    @Test
    @DisplayName("Test get all users")
    void testGetAllCategory(){
        when(userService.getListOfUsers()).thenReturn(getListUsersDto());
        List<UserDto> usersList = usersController.getAllUsers();
        assertEquals(getListUsersDto().toString(),usersList.toString());
    }

    @Test
    @DisplayName("Test delete user")
    void testDeleteUser(){
        usersController.deleteById(1L);
        verify(userService,times(1)).deleteUserById(longArgumentCaptor.capture());
        assertEquals(1, longArgumentCaptor.getValue());
    }


}