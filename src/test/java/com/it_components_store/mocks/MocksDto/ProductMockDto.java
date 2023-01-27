package com.it_components_store.mocks.MocksDto;

import com.it_components_store.dto.ProductDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductMockDto {
    public static ProductDto getOneProductDto() {
        return ProductDto.builder().idProduct(1L).name("mouse").stock(23456).price(200).description("Mouse gaming").code("pokmn85").categoryId(1L).build();

    }

    public static List<ProductDto> getListOfProductDto() {
        return List.of(
                ProductDto.builder().idProduct(1L).name("mouse").stock(23456).price(200).description("Mouse gaming").code("pokmn85").categoryId(1L).build(),
                ProductDto.builder().idProduct(1L).name("mouse").stock(23456).price(200).description("Mouse gaming").code("pokmn85").categoryId(1L).build(),
                ProductDto.builder().idProduct(1L).name("mouse").stock(23456).price(200).description("Mouse gaming").code("pokmn85").categoryId(1L).build()
        );
    }
}
