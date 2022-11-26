package com.it_components_store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    private Long idProduct;
    @Size(min = 3, message = "Numele produslui trebuie sa contina mai mult de 3 caractere!")
    @Size(max = 25, message = "Numele produslui trebuie sa contina mai putin  de 25 de caractere!")
    private String name;

    @NotNull(message = "Introdu pretul")
    private Integer price;

    @NotNull(message = "Introdu numarul de stocuri ")
    private Integer stock;

    @NotNull(message = "Adauga descrierea produslui")
    @Size(min = 3, message = "Descrierea produslui trebuie sa contina mai mult de 2 caractere!")
    @Size(max = 100, message = "Descrierea produslui trebuie sa contina  mai putin de 100 de caractere!")
    private String description;

    @Size(min = 3, message = "Codul produslui trebuie sa contina mai mult de 3 caractere!")
    @Size(max = 30, message = "Codul produslui trebuie sa contina mai putin de 30 caractere!")
    private String code;

    @NotNull(message = "Adauga cantitatea")
    private Integer quantity;

    @NotNull(message = "Adauga categoria produsului")
    private Long categoryId;

    @NotNull(message = "Adauga adresa URL a imaginii produslui!")
    private String imageUrl;


}
