package com.elyashevich.inventory_service.controller;

import com.elyashevich.inventory_service.dto.InventoryResponse;
import com.elyashevich.inventory_service.mapper.InventoryMapper;
import com.elyashevich.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventories")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;
    private final InventoryMapper inventoryMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(final @RequestParam List<String> skuCode) {
        var inventories = this.inventoryService.isInStock(skuCode);
        return this.inventoryMapper.toDto(inventories);
    }
}
