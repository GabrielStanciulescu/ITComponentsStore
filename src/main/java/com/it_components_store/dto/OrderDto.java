package com.it_components_store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
    private Long id;
    @Size(max = 30, message = "Numele trebuie sa contina mai putin de 30 de caractere!")
    private String firstName;

    private String orderCode;
    @Size(max = 30, message = "Prenumele  trebuie sa contina mai putin de 30 de caractere!")
    private String lastName;

    @Pattern(regexp = "^[\\w.+\\-]+@gmail\\.com$", message = "Adresa de mail este invalida!")
    @Size(max = 50, message = "Lungimea dresei de mail nu poate avea mai mult de 50 de caractere!")
    private String email;
    @NotNull
    @Size(max = 50, message = "Adresa  trebuie sa contina mai putin de 50 de caractere!")
    private String address;

    @NotNull
    @Pattern(regexp = "^(\\+4|)?(07\\d{2}|02\\d{2}|03\\d{2})(\\s|\\.|)?(\\d{3}(\\s|\\.|)){2}$",message = "Numarul  de telefon este invalid!")
    private String mobile;

    private String description;
    private Integer quantity;
    private Long idProduct;
    private Integer price;

}
