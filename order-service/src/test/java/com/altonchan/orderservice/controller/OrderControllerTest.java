package com.altonchan.orderservice.controller;

import com.altonchan.orderservice.client.GatewayClient;
import com.altonchan.orderservice.model.dto.InstrumentDTO;
import com.altonchan.orderservice.model.dto.OrderQtyDataDTO;
import com.altonchan.orderservice.model.dto.request.CreateOrderRequestDTO;
import com.altonchan.orderservice.model.dto.response.CreateOrderResponseDTO;
import com.altonchan.orderservice.model.enums.OrdType;
import com.altonchan.orderservice.model.enums.Side;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.altonchan.orderservice.model.enums.Status;
import com.altonchan.orderservice.repository.InstrumentRepository;
import com.altonchan.orderservice.repository.OrderRepository;
import com.altonchan.orderservice.service.interfaces.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
//@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = { WireMockConfig.class })
//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class OrderControllerTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GatewayClient gatewayClient;

    @Autowired
    private OrderService orderService;

    @Autowired
    private InstrumentRepository instrumentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createOrder() throws Exception {

        String jsonString = "{\n" +
                "    \"instrumentList\": [\n" +
                "        {\n" +
                "            \"cfiCode\": \"cfi-code-01\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"side\": \"1\",\n" +
                "    \"orderQtyDataList\": [\n" +
                "        {\n" +
                "            \"orderQty\": \"1.0\",\n" +
                "            \"cashOrderQty\": \"2.0\",\n" +
                "            \"orderPercent\": \"3.0\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"ordType\": \"1\"\n" +
                "}";
        CreateOrderRequestDTO createOrderRequestDTO = new ObjectMapper().readValue(jsonString, CreateOrderRequestDTO.class);

        this.mockMvc.perform(post("/order")
                        .contentType(APPLICATION_JSON)
                        .content(jsonString))
                .andDo(print())
                .andExpect(status().is(200));

    }

}