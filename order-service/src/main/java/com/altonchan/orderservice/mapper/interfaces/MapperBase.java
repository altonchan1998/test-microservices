package com.altonchan.orderservice.mapper.interfaces;

import java.util.List;

public interface MapperBase<E, D> {
    D toDTO(E source);
    List<D> toDTO(List<E> source);
    E toEntity(D source);
    List<E> toEntity(List<D> source);
}
