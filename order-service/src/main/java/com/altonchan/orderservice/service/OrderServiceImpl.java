package com.altonchan.orderservice.service;

import com.altonchan.orderservice.model.dto.request.CreateOrderRequestDTO;
import com.altonchan.orderservice.model.entity.Order;
import com.altonchan.orderservice.model.enums.Status;
import com.altonchan.orderservice.repository.OrderRepository;
import com.altonchan.orderservice.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order create(CreateOrderRequestDTO requestDTO) {
        Order order = new Order();
        order.setStatus(Status.SENT);
        return orderRepository.save(order);
    }
}
