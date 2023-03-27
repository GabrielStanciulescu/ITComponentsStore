package com.it_components_store.service.impl;

import com.it_components_store.dto.product_details_Dto.MouseDto;
import com.it_components_store.dto.product_details_Dto.RamDto;
import com.it_components_store.entity.product_details.Mouse;
import com.it_components_store.entity.product_details.Ram;
import com.it_components_store.exception.DataNotFoundException;
import com.it_components_store.exception.InvalidDataException;
import com.it_components_store.repository.product_details_repository.MouseRepository;
import com.it_components_store.repository.product_details_repository.RamRepository;
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
}
