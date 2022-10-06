package com.it_components_store.service.impl;


import com.it_components_store.entity.User;
import com.it_components_store.exception.DataNotFoundException;
import com.it_components_store.exception.InvalidDataException;
import com.it_components_store.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static com.it_components_store.mocks.UsersMock.getListUsers;
import static com.it_components_store.mocks.UsersMock.getOneUser;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UsersServiceImplTest {
    @InjectMocks
    UserServiceImpl usersService;

    @Mock
    UserRepository usersRepository;

    @Captor
    ArgumentCaptor<User> usersArgumentCaptor;

    @Captor
    ArgumentCaptor<Long> longArgumentCaptor;

        @Test
        @DisplayName("Testing add Users")
        void addUserTest() {
            User users = getOneUser();
            usersService.addUsers(users);
            verify(usersRepository,times(1)).save(usersArgumentCaptor.capture());
            assertEquals(users,usersArgumentCaptor.getValue());
    }

    @Test
    @DisplayName("Test throw DataNotFoundException ")
    void testThrowDataNotFoundException(){
            Exception exception = assertThrows(DataNotFoundException.class,()->usersService.addUsers(null));
            String expected = "Error Category not found!";
            String actual = exception.getMessage();
            assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test getUserByID")
    void testGetUserById(){
            when(usersRepository.findById(1L)).thenReturn(Optional.of(getOneUser()));
            Optional<User> usersOptional = usersService.getUsersById(1L);
            if (usersOptional.isPresent()){
                User users = usersOptional.get();
                assertEquals(getOneUser(),users);
            }
    }

    @Test
    @DisplayName("Test throw InvalidDataException")
    void testThrowInvalidDataExceptionGetById(){
        Exception exception = assertThrows(InvalidDataException.class,()->usersService.getUsersById(-1L));
        String expected = "Error! Your id -1 it's not valid";
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test throw DataNotFoundException")
    void testThrowDataNotFoundExceptionGetById(){
        when(usersRepository.findById(1L)).thenReturn(Optional.empty());
        Exception exception = assertThrows(DataNotFoundException.class,()->usersService.getUsersById(1L));
        String expected = "Error! The category with id 1 does not exist!";
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test get all users")
    void testGetAllUsers(){
            when(usersRepository.findAll()).thenReturn(getListUsers());
            List<User> usersList = usersService.getListOfUsers();
            assertEquals(getListUsers(),usersList);
    }

    @Test
    @DisplayName("Test throw DataNotFoundException ")
    void testThrowDataNotFoundExceptionGetAll(){
            when(usersRepository.findAll()).thenReturn(Collections.emptyList());
        Exception exception = assertThrows(DataNotFoundException.class,()->usersService.getListOfUsers());
        String expected = "Error! Category list it's empty";
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test delete by id")
    void testDeleteById(){
        when(usersRepository.findById(1L)).thenReturn(Optional.of(getOneUser()));
        usersService.deleteUserById(1L);
        verify(usersRepository, times(1)).deleteById(longArgumentCaptor.capture());
        assertEquals(1L, longArgumentCaptor.getValue());

    }

    @Test
    @DisplayName("Test throw InvalidDataException exception ")
    void testThrowDelete() {
        Exception exception = assertThrows(InvalidDataException.class, () -> usersService.deleteUserById(-1L));
        String expected = "Error! Your id -1 it's not valid, pleas try again with id >=0";
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test throw DataNotFoundException exception ")
    void testThrowDeleteEmptyDb() {

        Exception exception = assertThrows(DataNotFoundException.class, () -> usersService.deleteUserById(1L));
        String expected = "Error User with id 1 it's not present in database";
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }




























}