package com.it_components_store.service.impl;


import com.it_components_store.dto.UserDto;
import com.it_components_store.entity.User;
import com.it_components_store.exception.DataNotFoundException;
import com.it_components_store.exception.InvalidDataException;
import com.it_components_store.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.it_components_store.mocks.UserMockDto.getListUsersDto;
import static com.it_components_store.mocks.UserMockDto.getOneUserDto;
import static com.it_components_store.mocks.UsersMock.getListUsers;
import static com.it_components_store.mocks.UsersMock.getOneUser;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UsersServiceImplTest {
    @InjectMocks
    UserServiceImpl usersService;
    @Spy
    ModelMapper modelMapper;
    @Mock
    UserRepository usersRepository;
    @Captor
    ArgumentCaptor<User> usersArgumentCaptor;
    @Mock
    PasswordEncoder passwordEncoder;

    @Captor
    ArgumentCaptor<Long> longArgumentCaptor;

        @Test
        @DisplayName("Testing add Users")
        void addUserTest() {
            UserDto userDto = getOneUserDto();
            when(passwordEncoder.encode("asaSAsaSAs")).thenReturn("$2a$12$fr391cwxTqQwqG0gQ5e0aOhfOAtoTwV/1t9NWZCP6/s17PjOO81by");
            usersService.addUsers(userDto);
            verify(usersRepository).save(usersArgumentCaptor.capture());

            assertEquals(usersArgumentCaptor.getValue().toString(), getOneUser().toString());
    }

    @Test
    @DisplayName("Test throw DataNotFoundException for method addUsers ")
    void testThrowDataNotFoundException(){
            Exception exception = assertThrows(DataNotFoundException.class,()->usersService.addUsers(null));
            String expected = "User not found!";
            String actual = exception.getMessage();
            assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test getUserByID")
    void testGetUserById(){
            when(usersRepository.findById(1L)).thenReturn(Optional.of(getOneUser()));
            Optional<UserDto> usersOptional = usersService.getUsersById(1L);
            if (usersOptional.isPresent()){
                UserDto users = usersOptional.get();
                users.setPassword("asaSAsaSAs");
                assertEquals(getOneUserDto().toString(),users.toString());
            }
    }

    @Test
    @DisplayName("Test throw InvalidDataException for method getUsersById")
    void testThrowInvalidDataExceptionGetById(){
        Exception exception = assertThrows(InvalidDataException.class,()->usersService.getUsersById(-1L));
        String expected = "Your id -1 it's not valid";
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test throw DataNotFoundException for method getUsersById")
    void testThrowDataNotFoundExceptionGetById(){
        when(usersRepository.findById(1L)).thenReturn(Optional.empty());
        Exception exception = assertThrows(DataNotFoundException.class,()->usersService.getUsersById(1L));
        String expected = "The category with id 1 does not exist!";
        String actual = exception.getMessage();
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test get all users")
    void testGetAllUsers(){
            when(usersRepository.findAll()).thenReturn(getListUsers());
            List<UserDto> usersList = usersService.getListOfUsers();
            assertEquals(getListUsersDto().toString(),usersList.toString());
    }

    @Test
    @DisplayName("Test throw DataNotFoundException for method getListOfUsers ")
    void testThrowDataNotFoundExceptionGetAll(){
            when(usersRepository.findAll()).thenReturn(Collections.emptyList());
        Exception exception = assertThrows(DataNotFoundException.class,()->usersService.getListOfUsers());
        String expected = "Category list it's empty";
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
    @DisplayName("Test throw InvalidDataException exception  for method deleteUserById ")
    void testThrowDelete() {
        Exception exception = assertThrows(InvalidDataException.class, () -> usersService.deleteUserById(-1L));
        String expected = "Your id -1 it's not valid, pleas try again with id >=0";
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test throw DataNotFoundException exception for method deleteUserById ")
    void testThrowDeleteEmptyDb() {

        Exception exception = assertThrows(DataNotFoundException.class, () -> usersService.deleteUserById(1L));
        String expected = "User with id 1 it's not present in database";
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("Test get user by Email")
    void testGetUserByEmail(){
            when(usersRepository.findUsersByEmail("gabriel.stanculescu08@gmail.com")).thenReturn(Optional.of(getOneUser()));
            Optional<User> userOptional = usersService.getUserByEmail("gabriel.stanculescu08@gmail.com");
            if(userOptional.isPresent()){
                User user = userOptional.get();
                assertEquals(getOneUser().toString(), user.toString());
            }

    }

    @Test
    @DisplayName("Test throw DataNotFoundException for method getUserByEmail ")
    void testGetUserByEmailThrowException(){
            when(usersRepository.findUsersByEmail("gabriel.stanculescu08@gmail.com")).thenReturn(Optional.empty());
            Exception exception = assertThrows(DataNotFoundException.class, ()->usersService.getUserByEmail("gabriel.stanculescu08@gmail.com"));
             String expected = "The user does not exist!";
            String actual = exception.getMessage();
            assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test getByResetPasswordToken ")
    void testGetByResetPasswordToken(){
            when(usersRepository.findUserByResetPasswordToken("BED1fNhxlAky6m0VZZ4h6QwWccWpzd")).thenReturn(Optional.of(getOneUser()));
            Optional<User> userOptional = usersService.getByResetPasswordToken("BED1fNhxlAky6m0VZZ4h6QwWccWpzd");
            if (userOptional.isPresent()){
                User user = userOptional.get();
                assertEquals(getOneUser().toString(),user.toString());
            }
    }

    @Test
    @DisplayName("Test throw DataNotFoundException for method getByResetPasswordToken")
    void testThrowGetByResetPasswordToken(){
            when(usersRepository.findUserByResetPasswordToken("BED1fNhxlAky6m0VZZ4h6QwWccWpzd")).thenReturn(Optional.empty());
            Exception exception = assertThrows(DataNotFoundException.class, ()->usersService.getByResetPasswordToken("BED1fNhxlAky6m0VZZ4h6QwWccWpzd"));
            String expected = "The user does not exist!";
            String actual = exception.getMessage();
            assertEquals(expected,actual);
    }



    @Test
    @DisplayName("Test get user by Email")
    void testUpdateResetPasswordToken(){
        when(usersRepository.findUsersByEmail("gabriel.stanculescu08@gmail.com")).thenReturn(Optional.of(getOneUser()));
        usersService. updateResetPasswordToken("BED1fNhxlAky6m0VZZ4h6QwWccWpzd","gabriel.stanculescu08@gmail.com");
        verify(usersRepository).save(usersArgumentCaptor.capture());
        assertEquals(usersArgumentCaptor.getValue().toString(), getOneUser().toString());
    }

    @Test
    @DisplayName("Test throw DataNotFoundException for method updateResetPasswordToken")
    void testThrowExceptionUpdateResetPasswordToken(){
        when(usersRepository.findUsersByEmail("gabriel.stanculescu08@gmail.com")).thenReturn(Optional.empty());
        Exception exception = assertThrows(DataNotFoundException.class, ()->usersService.updateResetPasswordToken("BED1fNhxlAky6m0VZZ4h6QwWccWpzd","gabriel.stanculescu08@gmail.com"));
        String expected = "The user does not exist!";
        String actual = exception.getMessage();
        assertEquals(expected,actual);

    }

    @Test
    @DisplayName("Test updatePassword")
    void testUpdatePassword(){
            User user = getOneUser();
        when(passwordEncoder.encode("asaSAsaSAs")).thenReturn("$2a$12$fr391cwxTqQwqG0gQ5e0aOhfOAtoTwV/1t9NWZCP6/s17PjOO81by");
        usersService.updatePassword(user, "asaSAsaSAs");
        verify(usersRepository).save(usersArgumentCaptor.capture());
        user.setResetPasswordToken("BED1fNhxlAky6m0VZZ4h6QwWccWpzd");
        assertEquals(usersArgumentCaptor.getValue().toString(), getOneUser().toString());


    }






//
//    void addUserTest() {
//        UserDto userDto = getOneUserDto();
//        when(passwordEncoder.encode("asaSAsaSAs")).thenReturn("$2a$12$fr391cwxTqQwqG0gQ5e0aOhfOAtoTwV/1t9NWZCP6/s17PjOO81by");
//        usersService.addUsers(userDto);
//        verify(usersRepository).save(usersArgumentCaptor.capture());
//
//        assertEquals(usersArgumentCaptor.getValue().toString(), getOneUser().toString());
//    }
//










}