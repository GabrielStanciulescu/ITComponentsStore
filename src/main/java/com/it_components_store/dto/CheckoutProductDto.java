package com.it_components_store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CheckoutProductDto {
    private Long id;
    private String orderCode;
    private Integer price;
    private LocalDate localDate;
    private Long idUser;


}
