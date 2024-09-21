package com.elyashevich.product_service.service;

import com.elyashevich.product_service.dto.ProductRequest;
import com.elyashevich.product_service.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product create(final ProductRequest productRequest);
}
