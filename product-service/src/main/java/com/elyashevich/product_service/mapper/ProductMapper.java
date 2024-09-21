package com.elyashevich.product_service.mapper;

import com.elyashevich.product_service.dto.ProductResponse;
import com.elyashevich.product_service.model.Product;

import java.util.List;

public interface ProductMapper {

    ProductResponse toDto(final Product product);

    List<ProductResponse> toDto(final List<Product> products);
}
