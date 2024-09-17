package com.electroboy.dreamshops.service.order;

import com.electroboy.dreamshops.dto.OrderDto;
import com.electroboy.dreamshops.model.Order;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);
    OrderDto getOrder(Long orderId);
    List<OrderDto> getUserOrders(Long userId);
    OrderDto convertToDto(Order order);
}
