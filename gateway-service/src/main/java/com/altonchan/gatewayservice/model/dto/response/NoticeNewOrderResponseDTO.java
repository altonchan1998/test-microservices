package com.altonchan.gatewayservice.model.dto.response;

import com.altonchan.gatewayservice.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor @NoArgsConstructor
public class NoticeNewOrderResponseDTO {
    private UUID clOrderID;
    private Status status;
}
