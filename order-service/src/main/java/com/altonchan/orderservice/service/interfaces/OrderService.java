package com.altonchan.orderservice.service.interfaces;

import com.altonchan.orderservice.model.dto.request.CreateOrderRequestDTO;
import com.altonchan.orderservice.model.entity.Order;

public interface OrderService {
    Order create(CreateOrderRequestDTO requestDTO);
}
