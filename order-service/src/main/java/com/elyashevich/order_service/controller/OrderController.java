package com.elyashevich.order_service.controller;

import com.elyashevich.order_service.dto.OrderRequest;
import com.elyashevich.order_service.dto.OrderResponse;
import com.elyashevich.order_service.mapper.OrderMapper;
import com.elyashevich.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    private final OrderMapper orderMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse create(final @RequestBody OrderRequest orderRequest) {
        var order = this.orderService.create(orderRequest);
        return this.orderMapper.toDto(order);
    }
}
