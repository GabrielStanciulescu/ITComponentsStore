package com.it_components_store.rest_controllers;

import com.it_components_store.entity.User;
import com.it_components_store.service.UserService;
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

import static com.it_components_store.mocks.UsersMock.getListUsers;
import static com.it_components_store.mocks.UsersMock.getOneUser;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsersControllerTest {
    @InjectMocks
    UsersController usersController;

    @Mock
    UserService userService;

    @Captor
    ArgumentCaptor<User> userArgumentCaptor;

    @Captor
    ArgumentCaptor<Long> longArgumentCaptor;

    @Test
    void addUsers() {
        User user = getOneUser();
        usersController.addUsers(user);
        verify(userService,times(1)).addUsers(userArgumentCaptor.capture());
      assertEquals(user,userArgumentCaptor.getValue());

    }

    @Test
    @DisplayName("Test get user by name")
    void testGetUserByName() {
        when(userService.getUsersById(1L)).thenReturn(Optional.of(getOneUser()));
        Optional<User> userOptional = usersController.getUsersById(1L);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            assertEquals(getOneUser(), user);
        }
    }

    @Test
    @DisplayName("Test get all users")
    void testGetAllCategory(){
        when(userService.getListOfUsers()).thenReturn(getListUsers());
        List<User> usersList = usersController.getAllUsers();
        assertEquals(getListUsers(), usersList);
    }

    @Test
    @DisplayName("Test delete user")
    void testDeleteUser(){
        usersController.deleteById(1L);
        verify(userService,times(1)).deleteUserById(longArgumentCaptor.capture());
        assertEquals(1, longArgumentCaptor.getValue());
    }


}