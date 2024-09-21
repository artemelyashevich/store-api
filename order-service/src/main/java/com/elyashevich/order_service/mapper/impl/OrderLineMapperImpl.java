package com.elyashevich.order_service.mapper.impl;

import com.elyashevich.order_service.dto.OrderLineItemsDto;
import com.elyashevich.order_service.mapper.OrderLineMapper;
import com.elyashevich.order_service.model.OrderLineItems;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderLineMapperImpl implements OrderLineMapper {

    @Override
    public OrderLineItemsDto toDto(OrderLineItems entity) {
        return null;
    }

    @Override
    public List<OrderLineItemsDto> toDto(List<OrderLineItems> entities) {
        return null;
    }

    @Override
    public OrderLineItems toEntity(OrderLineItemsDto dto) {
        return OrderLineItems.builder()
                .id(dto.getId())
                .price(dto.getPrice())
                .skuCode(dto.getSkuCode())
                .quantity(dto.getQuantity())
                .build();
    }

    @Override
    public List<OrderLineItems> toEntity(List<OrderLineItemsDto> dtoList) {
        return dtoList.stream()
                .map(this::toEntity)
                .toList();
    }
}
