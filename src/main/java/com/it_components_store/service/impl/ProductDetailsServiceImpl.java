package com.it_components_store.service.impl;

import com.it_components_store.dto.product_details_Dto.*;
import com.it_components_store.entity.product_details.*;
import com.it_components_store.exception.DataNotFoundException;
import com.it_components_store.exception.InvalidDataException;
import com.it_components_store.repository.product_details_repository.*;
import com.it_components_store.service.ProductDetailsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ProductDetailsServiceImpl implements ProductDetailsService {

    private final MouseRepository mouseRepository;
    private final RamRepository ramRepository;
    private final HddRepository hddRepository;
    private final SsdRepository ssdRepository;
    private final CpuRepository cpuRepository;
    private final GpuRepository gpuRepository;
    private final CaseRepository caseRepository;
    private final HeadphonesRepository headphonesRepository;
    private final SourceRepository sourceRepository;
    private final MonitorRepository monitorRepository;
    private final MotherboardRepository motherboardRepository;
    private final ModelMapper modelMapper;
    @Override
    public Optional<MouseDto> getMouseDetailsByIdCategory(Long id) {

        if (id < 0) {
            throw new InvalidDataException("Your id " + id + " it's not valid");
        }

        Optional<Mouse> optionalMouse = mouseRepository.getByProductId(id);
        if (optionalMouse.isEmpty()){
            throw new DataNotFoundException("The product with id " + id + " does not exist!");
        }
        else{
            Mouse mouse = optionalMouse.get();
            MouseDto mouseDto = modelMapper.map(mouse, MouseDto.class);
            return Optional.of(mouseDto);
        }
    }


    @Override
    public Optional<RamDto> getRamDetailsByIdCategory(Long id) {
        if (id < 0) {
            throw new InvalidDataException("Your id " + id + " it's not valid");
        }

        Optional<Ram> optionalRam = ramRepository.getByProductId(id);
        if (optionalRam.isEmpty()){
            throw new DataNotFoundException("The product with id " + id + " does not exist!");
        }
        else{
            Ram ram = optionalRam.get();
            RamDto ramDto = modelMapper.map(ram, RamDto.class);
            return Optional.of(ramDto);
        }
    }

    @Override
    public Optional<HddDto> getHddDetailsByIdCategory(Long id) {
        if (id < 0) {
            throw new InvalidDataException("Your id " + id + " it's not valid");
        }

        Optional<Hdd> optionalHdd = hddRepository.getByProductId(id);
        if (optionalHdd.isEmpty()){
            throw new DataNotFoundException("The product with id " + id + " does not exist!");
        }
        else{
            Hdd hdd = optionalHdd.get();
            HddDto hddDto = modelMapper.map(hdd, HddDto.class);
            return Optional.of(hddDto);
        }
    }

    @Override
    public Optional<SsdDto> getSsdDetailsByIdCategory(Long id) {
        if (id < 0) {
            throw new InvalidDataException("Your id " + id + " it's not valid");
        }


        Optional<Ssd> optionalSsd = ssdRepository.getByProductId(id);
        if (optionalSsd.isEmpty()){
            throw new DataNotFoundException("The product with id " + id + " does not exist!");
        }
        else{
            Ssd ssd = optionalSsd.get();
            SsdDto ssdDto = modelMapper.map(ssd, SsdDto.class);
            return Optional.of(ssdDto);
        }
    }

    @Override
    public Optional<CpuDto> getCpuDetailsByIdCategory(Long id) {
        if (id < 0) {
            throw new InvalidDataException("Your id " + id + " it's not valid");
        }


        Optional<Cpu> optionalCpu = cpuRepository.getByProductId(id);
        if (optionalCpu.isEmpty()){
            throw new DataNotFoundException("The product with id " + id + " does not exist!");
        }
        else{
            Cpu cpu = optionalCpu.get();
            CpuDto cpuDto = modelMapper.map(cpu, CpuDto.class);
            return Optional.of(cpuDto);
        }
    }

    @Override
    public Optional<GpuDto> getGpuDetailsByIdCategory(Long id) {
        if (id < 0) {
            throw new InvalidDataException("Your id " + id + " it's not valid");
        }


        Optional<Gpu> optionalGpu = gpuRepository.getByProductId(id);
        if (optionalGpu.isEmpty()){
            throw new DataNotFoundException("The product with id " + id + " does not exist!");
        }
        else{
            Gpu gpu = optionalGpu.get();
            GpuDto gpuDto = modelMapper.map(gpu, GpuDto.class);
            return Optional.of(gpuDto);
        }
    }

    @Override
    public Optional<MotherboardDto> getMotherboardDetailsByIdCategory(Long id) {
        if (id < 0) {
            throw new InvalidDataException("Your id " + id + " it's not valid");
        }



        Optional<Motherboard> optionalMotherboard = motherboardRepository.getByProductId(id);
        if (optionalMotherboard.isEmpty()){
            throw new DataNotFoundException("The product with id " + id + " does not exist!");
        }
        else{
            Motherboard motherboard = optionalMotherboard.get();
            MotherboardDto motherboardDto = modelMapper.map(motherboard, MotherboardDto.class);
            return Optional.of(motherboardDto);
        }
    }

    @Override
    public Optional<MonitorDto> getMonitorDetailsByIdCategory(Long id) {
        if (id < 0) {
            throw new InvalidDataException("Your id " + id + " it's not valid");
        }



        Optional<Monitor> optionalMonitor = monitorRepository.getByProductId(id);
        if (optionalMonitor.isEmpty()){
            throw new DataNotFoundException("The product with id " + id + " does not exist!");
        }
        else{
            Monitor monitor = optionalMonitor.get();
            MonitorDto motherboardDto = modelMapper.map(monitor, MonitorDto.class);
            return Optional.of(motherboardDto);
        }
    }

    @Override
    public Optional<CaseDto> getCaseDetailsByIdCategory(Long id) {


        if (id < 0) {
            throw new InvalidDataException("Your id " + id + " it's not valid");
        }



        Optional<Case> optionalMonitor = caseRepository.getByProductId(id);
        if (optionalMonitor.isEmpty()){
            throw new DataNotFoundException("The product with id " + id + " does not exist!");
        }
        else{
            Case aCase = optionalMonitor.get();
            CaseDto caseDto = modelMapper.map(aCase, CaseDto.class);
            return Optional.of(caseDto);
        }
    }

    @Override
    public Optional<SourceDto> getSourceDetailsByIdCategory(Long id) {
        if (id < 0) {
            throw new InvalidDataException("Your id " + id + " it's not valid");
        }



        Optional<Source> optionalSource = sourceRepository.getByProductId(id);
        if (optionalSource.isEmpty()){
            throw new DataNotFoundException("The product with id " + id + " does not exist!");
        }
        else{
            Source source = optionalSource.get();
            SourceDto sourceDto = modelMapper.map(source, SourceDto.class);
            return Optional.of(sourceDto);
        }
    }

    @Override
    public Optional<HeadphonesDto> getHeadphonesDetailsByIdCategory(Long id) {

        if (id < 0) {
            throw new InvalidDataException("Your id " + id + " it's not valid");
        }

        Optional<Headphones> optionalHeadphones = headphonesRepository.getByProductId(id);
        if (optionalHeadphones.isEmpty()){
            throw new DataNotFoundException("The product with id " + id + " does not exist!");
        }
        else{
            Headphones headphones = optionalHeadphones.get();
            HeadphonesDto headphonesDto = modelMapper.map(headphones, HeadphonesDto.class);
            return Optional.of(headphonesDto);
        }

    }
}
