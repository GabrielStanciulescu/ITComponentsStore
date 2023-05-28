package com.it_components_store.dto.product_details_Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MouseDto {
    private long idMouse;
    private String name;
    private String interfaceMouse;
    private String sensor;
    private String color;
    private Long productId;
}
