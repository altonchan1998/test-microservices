package com.altonchan.gatewayservice.model.dto.request;

import com.altonchan.gatewayservice.constant.ValidationMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor @NoArgsConstructor
public class NoticeNewOrderRequestDTO {

    @NotNull(message = ValidationMessages.NOT_NULL)
    private UUID clOrderID;
}
