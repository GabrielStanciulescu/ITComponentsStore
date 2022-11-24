package com.it_components_store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long idUser;
    @NotNull
    @Size(min = 3, max = 20)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 20)
    private String lastName;

    @NotNull
    @Email
    @Pattern(regexp = "^[\\w.+\\-]+@gmail\\.com$", message = "The email is invalid")
    @Size(max = 100, message = "The maximum length is 100 characters")
    private String email;

    @NotNull
    @Size(max = 100, message = "The maximum length for password is 100 characters")
    private String password;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @NotNull
    @Size(max = 30, message = "The maximum length for address is 30 characters")
    private String address;

    @NotNull
    @Size(max = 15, message = "The maximum length for mobile is 15 characters")
    private String mobile;

    private Long idRole;
}
