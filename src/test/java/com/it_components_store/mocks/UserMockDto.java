package com.it_components_store.mocks;

import com.it_components_store.dto.UserDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMockDto {
    public static UserDto getOneUserDto() {
        return UserDto.builder().lastName("test").firstName("test").address("test").idRole(2L).build();

    }

    public static List<UserDto> getListUsersDto() {

        return List.of(UserDto.builder().lastName("test").firstName("test").address("test").idRole(2L).build());
    }
}
