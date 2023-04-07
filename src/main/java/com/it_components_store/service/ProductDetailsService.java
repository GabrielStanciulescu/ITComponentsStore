package com.it_components_store.service;

import com.it_components_store.dto.product_details_Dto.*;

import java.util.Optional;

public interface ProductDetailsService {

    Optional<MouseDto> getMouseDetailsByIdCategory(Long id);
    Optional<RamDto> getRamDetailsByIdCategory(Long id);
    Optional<HddDto> getHddDetailsByIdCategory(Long id);
    Optional<SsdDto> getSsdDetailsByIdCategory(Long id);
    Optional<CpuDto> getCpuDetailsByIdCategory(Long id);




}
