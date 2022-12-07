package com.altonchan.orderservice.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class NoticeNewOrderRequestDTO {

    @NotBlank
    private UUID clOrderID;
}
