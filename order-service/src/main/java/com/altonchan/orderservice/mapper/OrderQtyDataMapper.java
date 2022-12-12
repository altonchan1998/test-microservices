package com.altonchan.orderservice.mapper;

import com.altonchan.orderservice.model.dto.OrderQtyDataDTO;
import com.altonchan.orderservice.model.entity.OrderQtyData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderQtyDataMapper extends MapperBase<OrderQtyData, OrderQtyDataDTO> {
}
