package com.altonchan.orderservice.controller;

import com.altonchan.orderservice.model.dto.request.CreateOrderRequestDTO;
import com.altonchan.orderservice.model.dto.request.NoticeNewOrderRequestDTO;
import com.altonchan.orderservice.model.entity.Order;
import com.altonchan.orderservice.model.enums.Status;
import com.altonchan.orderservice.repository.OrderRepository;
import com.altonchan.orderservice.service.OrderServiceImpl;
import com.altonchan.orderservice.service.client.GatewayServiceFeignClient;
import com.altonchan.orderservice.service.interfaces.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class OrderController {

    @Autowired
    private GatewayServiceFeignClient gatewayServiceFeignClient;

    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public void createOrder(
            @RequestBody
            @Valid CreateOrderRequestDTO createOrderRequestDTO
    ) {

        UUID clOrderId = orderService.create(createOrderRequestDTO).getClOrderID();

        gatewayServiceFeignClient.noticeNewOrder(new NoticeNewOrderRequestDTO(clOrderId));
    }

    @GetMapping("/list")
    public List<String> getList() {
        return List.of("1", "2", "3");
    }

}
