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
    @Size(max = 20, message = "The maximum length for  first name ")
    private String firstName;

    private String orderCode;
    @Size(max = 20, message = "The maximum length for  last name ")
    private String lastName;

    @Pattern(regexp = "^[\\w.+\\-]+@gmail\\.com$", message = "The email is invalid")
    @Size(max = 100, message = "The maximum length is 100 characters")
    private String email;

    @NotNull
    @Size(max = 30, message = "The maximum length for address is 30 characters")
    private String address;

    @NotNull
    @Size(max = 15, message = "The maximum length for mobile is 15 characters")
    private String mobile;

    private String description;
    private Integer quantity;
    private Long idProduct;
    private Integer price;

}
