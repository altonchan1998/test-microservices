package com.altonchan.orderservice.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter @Setter
public class Order {

    @Id
    @Column
    private String clOrderID;

    @Column
    private char orderType;



}
