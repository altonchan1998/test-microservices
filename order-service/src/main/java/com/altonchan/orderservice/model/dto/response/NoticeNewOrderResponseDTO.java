package com.altonchan.orderservice.model.dto.response;

import com.altonchan.orderservice.model.enums.Status;
import lombok.Data;

@Data
public class NoticeNewOrderResponseDTO {
    private String clOrderID;
    private Status status;
}
