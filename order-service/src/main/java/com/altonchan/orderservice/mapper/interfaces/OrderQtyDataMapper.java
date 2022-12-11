package com.altonchan.orderservice.mapper.interfaces;

import com.altonchan.orderservice.model.dto.InstrumentDTO;
import com.altonchan.orderservice.model.dto.OrderQtyDataDTO;
import com.altonchan.orderservice.model.entity.Instrument;
import com.altonchan.orderservice.model.entity.OrderQtyData;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OrderQtyDataMapper extends MapperBase<OrderQtyData, OrderQtyDataDTO> {
}
