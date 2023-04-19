package com.it_components_store.service;

import com.it_components_store.dto.product_details_Dto.*;
import com.it_components_store.entity.product_details.Monitor;
import com.it_components_store.entity.product_details.Motherboard;

import java.util.Optional;

public interface ProductDetailsService {

    Optional<MouseDto> getMouseDetailsByIdCategory(Long id);
    Optional<RamDto> getRamDetailsByIdCategory(Long id);
    Optional<HddDto> getHddDetailsByIdCategory(Long id);
    Optional<SsdDto> getSsdDetailsByIdCategory(Long id);
    Optional<CpuDto> getCpuDetailsByIdCategory(Long id);
    Optional<GpuDto> getGpuDetailsByIdCategory(Long id);
    Optional<MotherboardDto> getMotherboardDetailsByIdCategory(Long id);
    Optional<MonitorDto> getMonitorDetailsByIdCategory(Long id);
    Optional<CaseDto> getCaseDetailsByIdCategory(Long id);
    Optional<SourceDto> getSourceDetailsByIdCategory(Long id);




}
