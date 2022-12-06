package com.altonchan.orderservice.controller;


import com.altonchan.orderservice.model.dto.request.CreateOrderRequestDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @PostMapping("/order")
    public void createOrder(
            @RequestBody
            @Valid
            CreateOrderRequestDTO createOrderRequestDTO
    ) {

    }
}
