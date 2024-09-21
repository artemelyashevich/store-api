package com.elyashevich.order_service.service.impl;

import com.elyashevich.order_service.dto.InventoryResponse;
import com.elyashevich.order_service.dto.OrderRequest;
import com.elyashevich.order_service.mapper.OrderLineMapper;
import com.elyashevich.order_service.model.Order;
import com.elyashevich.order_service.model.OrderLineItems;
import com.elyashevich.order_service.repository.OrderRepository;
import com.elyashevich.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderLineMapper orderLineMapper;

    private final WebClient webClient;

    @Transactional
    @Override
    public Order create(OrderRequest orderRequest) {
        var order = new Order();
        var orderLineItems = this.orderLineMapper.toEntity(orderRequest.getOrderLineItems());

        order.setOrderNumber(UUID.randomUUID().toString());
        order.setOrderLineItems(orderLineItems);

        var codes = order.getOrderLineItems().stream()
                .map(OrderLineItems::getSkuCode)
                .toList();

        var result = this.webClient.get()
                .uri("http://localhost:8083/api/v1/inventories",
                        uriBuilder -> uriBuilder.queryParam("skuCode", codes).build()
                )
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        boolean allProductsInStock = Arrays.stream(result)
                .allMatch(InventoryResponse::isInStock);

        if (!allProductsInStock) {
            throw new IllegalArgumentException("Product is not in stock.");
        }
        return this.orderRepository.save(order);
    }
}
