package com.elyashevich.product_service.service.impl;

import com.elyashevich.product_service.dto.ProductRequest;
import com.elyashevich.product_service.model.Product;
import com.elyashevich.product_service.repository.ProductRepository;
import com.elyashevich.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product create(final ProductRequest productRequest) {
        var product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        return this.productRepository.save(product);
    }
}
