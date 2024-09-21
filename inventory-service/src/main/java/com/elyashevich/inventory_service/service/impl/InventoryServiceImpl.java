package com.elyashevich.inventory_service.service.impl;

import com.elyashevich.inventory_service.repository.InventoryRepository;
import com.elyashevich.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    @Override
    public boolean isInStock(String skuCode) {
        return this.inventoryRepository.existsBySkuCode(skuCode);
    }
}
