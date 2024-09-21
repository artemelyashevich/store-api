package com.elyashevich.order_service.mapper;

import com.elyashevich.order_service.dto.OrderLineItemsDto;
import com.elyashevich.order_service.model.OrderLineItems;

public interface OrderLineMapper extends Mappable<OrderLineItems, OrderLineItemsDto> {
}
