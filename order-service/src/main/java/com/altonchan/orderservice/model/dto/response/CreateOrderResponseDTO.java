package com.altonchan.orderservice.model.dto.response;

import com.altonchan.orderservice.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CreateOrderResponseDTO {
    private UUID clOrderId;
    private Status status;
}
