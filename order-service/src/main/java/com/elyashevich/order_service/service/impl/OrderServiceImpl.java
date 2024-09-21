package com.elyashevich.order_service.service.impl;

import com.elyashevich.order_service.dto.OrderRequest;
import com.elyashevich.order_service.mapper.OrderLineMapper;
import com.elyashevich.order_service.model.Order;
import com.elyashevich.order_service.repository.OrderRepository;
import com.elyashevich.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderLineMapper orderLineMapper;

    @Override
    public Order create(OrderRequest orderRequest) {
        var order = new Order();
        var orderLineItems = this.orderLineMapper.toEntity(orderRequest.getOrderLineItems());

        order.setOrderNumber(UUID.randomUUID().toString());
        order.setOrderLineItems(orderLineItems);

        return this.orderRepository.save(order);
    }
}
