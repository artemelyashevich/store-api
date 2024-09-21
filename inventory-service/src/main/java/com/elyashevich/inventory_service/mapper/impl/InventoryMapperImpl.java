package com.elyashevich.inventory_service.mapper.impl;

import com.elyashevich.inventory_service.dto.InventoryResponse;
import com.elyashevich.inventory_service.mapper.InventoryMapper;
import com.elyashevich.inventory_service.model.Inventory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InventoryMapperImpl implements InventoryMapper {

    @Override
    public InventoryResponse toDto(Inventory inventory) {
        return InventoryResponse.builder()
                .skuCode(inventory.getSkuCode())
                .isInStock(inventory.getQuantity() > 0)
                .build();
    }

    @Override
    public List<InventoryResponse> toDto(List<Inventory> inventories) {
        return inventories.stream()
                .map(this::toDto)
                .toList();
    }
}
