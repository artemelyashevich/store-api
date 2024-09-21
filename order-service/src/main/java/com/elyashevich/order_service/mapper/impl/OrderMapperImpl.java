package com.elyashevich.order_service.mapper.impl;

import com.elyashevich.order_service.dto.OrderResponse;
import com.elyashevich.order_service.mapper.OrderMapper;
import com.elyashevich.order_service.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderResponse toDto(Order entity) {
        return OrderResponse.builder()
                .id(entity.getId())
                .orderNumber(entity.getOrderNumber())
                .build();
    }

    @Override
    public List<OrderResponse> toDto(List<Order> entities) {
        return entities.stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public Order toEntity(OrderResponse dto) {
        return Order.builder().build();
    }

    @Override
    public List<Order> toEntity(List<OrderResponse> dtoList) {
        return dtoList.stream()
                .map(this::toEntity)
                .toList();
    }
}
