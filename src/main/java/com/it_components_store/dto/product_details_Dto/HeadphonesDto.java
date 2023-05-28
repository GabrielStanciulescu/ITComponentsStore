package com.it_components_store.dto.product_details_Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HeadphonesDto {

    private long idHeadphones;
    private String name;
    private String warrant;
    private String technology;
    private String sound;
    private String microphone;
    private Long productId;
}
