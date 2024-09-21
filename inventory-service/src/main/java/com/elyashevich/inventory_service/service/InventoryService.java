package com.elyashevich.inventory_service.service;

import com.elyashevich.inventory_service.dto.InventoryResponse;
import com.elyashevich.inventory_service.model.Inventory;

import java.util.List;

public interface InventoryService {

    List<Inventory> isInStock(List<String> skuCode);
}
