package com.elyashevich.inventory_service.mapper;

import com.elyashevich.inventory_service.dto.InventoryResponse;
import com.elyashevich.inventory_service.model.Inventory;

import java.util.List;

public interface InventoryMapper {

    InventoryResponse toDto(Inventory inventory);

    List<InventoryResponse> toDto(List<Inventory> inventories);
}
