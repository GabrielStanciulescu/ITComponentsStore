package com.it_components_store.dto.product_details_Dto;

import com.it_components_store.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MonitorDto {
    private long idMonitor;
    private String name;
    private String warrant;
    private String panel;
    private String diagonal;
    private String antiGlare;
    private String resolution;
    private String refreshRate;
    private Product productId;


}
