package com.it_components_store.service;

import com.it_components_store.dto.product_details_Dto.HddDto;
import com.it_components_store.dto.product_details_Dto.MouseDto;
import com.it_components_store.dto.product_details_Dto.RamDto;
import com.it_components_store.dto.product_details_Dto.SsdDto;

import java.util.Optional;

public interface ProductDetailsService {

    Optional<MouseDto> getMouseDetailsByIdCategory(Long id);
    Optional<RamDto> getRamDetailsByIdCategory(Long id);
    Optional<HddDto> getHddDetailsByIdCategory(Long id);
    Optional<SsdDto> getSsdDetailsByIdCategory(Long id);




}
