package com.elyashevich.order_service.mapper;

import com.elyashevich.order_service.dto.OrderResponse;
import com.elyashevich.order_service.model.Order;

public interface OrderMapper extends Mappable<Order, OrderResponse> {
}
