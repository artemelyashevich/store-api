package com.elyashevich.product_service.mapper.impl;

import com.elyashevich.product_service.dto.ProductResponse;
import com.elyashevich.product_service.mapper.ProductMapper;
import com.elyashevich.product_service.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapperImpl implements ProductMapper {
    @Override
    public ProductResponse toDto(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    @Override
    public List<ProductResponse> toDto(List<Product> products) {
        return products
                .stream()
                .map(this::toDto)
                .toList();
    }
}
