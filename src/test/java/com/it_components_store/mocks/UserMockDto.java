package com.it_components_store.mocks;

import com.it_components_store.dto.UserDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMockDto {
    public static UserDto getOneUserDto() {
        return UserDto.builder().lastName("test").firstName("test").address("gabriel.stanculescu08@gmail.com").password("asaSAsaSAs").idRole(1L).resetPasswordToken("BED1fNhxlAky6m0VZZ4h6QwWccWpzd").build();

    }

    public static List<UserDto> getListUsersDto() {

        return List.of(UserDto.builder().lastName("test").firstName("test").address("gabriel.stanculescu08@gmail.com").resetPasswordToken("BED1fNhxlAky6m0VZZ4h6QwWccWpzd").idRole(2L).build());
    }
}
