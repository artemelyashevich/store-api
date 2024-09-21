package com.elyashevich.product_service.controller;

import com.elyashevich.product_service.dto.ProductRequest;
import com.elyashevich.product_service.dto.ProductResponse;
import com.elyashevich.product_service.mapper.ProductMapper;
import com.elyashevich.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    private final ProductMapper productMapper;

    @GetMapping
    public List<ProductResponse> getAll() {
        var products = this.productService.getAll();
        return this.productMapper.toDto(products);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse create(final @RequestBody ProductRequest productRequest) {
        var product = this.productService.create(productRequest);
        return this.productMapper.toDto(product);
    }
}
