package com.elyashevich.order_service.service;

import com.elyashevich.order_service.dto.OrderRequest;
import com.elyashevich.order_service.model.Order;


public interface OrderService {

    Order create(OrderRequest orderRequest);
}
